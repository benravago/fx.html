
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//  Convert DOM-TS junit4 test cases to junit5

public class Mod {
    public static void main(String...args) throws Exception {
        if (args.length < 2) {
            System.err.println("usage: Mod <in.dir> <out.dir>");
        } else {
            new Mod().start(args);
        }
    }

    void start(String...args) throws Exception {
        var in = Paths.get(args[0]);
        var out = Paths.get(args[1]);
        Files.createDirectories(out);
        var p = allTests(in);
        for (var e:p.entrySet()) {
            var fn = (String) e.getKey();
            var cn = ((String)e.getValue()).trim() + "_Test";
            // System.out.println( fn + ": return " + cn );
            var src = Files.readString(in.resolve(fn+".java"));
            var text = transform(cn,src);
            Files.writeString(out.resolve(cn+".java"),text);
        }
    }

    Properties allTests(Path in) throws Exception {
        var p = new Properties();
        p.load(Files.newInputStream(in.resolve("alltests.properties")));
        p.remove("alltests");
        return p;
    }

    public String transform(String name, String in) {
        var a = in.indexOf("package",0);
        var b = in.indexOf("extends DOMTestCase",a);
        var c = in.indexOf("final DOMTestDocumentBuilderFactory",b);
        var d = in.indexOf("void runTest()",c);
        var e = in.indexOf("String getTargetURI()",d);
        var prefix = prefix(in,a,b);
        var comment = comment(in,b);
        var setup = setUp(in,c,d);
        var run = runTest(in,d,e);
        var uri = getTargetURI(in,e);
        return prefix + comment
             + "\nclass " + name + " extends domts.DOMTestCase {\n"
             + " @BeforeEach\n"
             + " void setup() " + setup + '\n'
             + " @Test\n"
             + " @DisplayName(" + uri + ")\n"
             + " void run() throws Throwable " + run
             + "\n}";
    }

    String prefix(String in, int a, int b) { // package ...
        var p = in.indexOf("org.w3c.",a) + 8;
        var q = in.indexOf('\n',p) + 1;
        return "package " + in.substring(p,q)
             + orgW3C(in,a,b)
             + "import java.util.*;\n"
             + "import org.junit.jupiter.api.*;\n"
             + "import static org.junit.jupiter.api.Assertions.*;\n";
        }

    Matcher dom = Pattern.compile("import org\\.w3c\\.dom\\..*?;").matcher("");

    String orgW3C(String in, int a, int b) {
        var buf = new StringBuilder();
        var m = dom.reset(in).region(a,b);
        while (m.find()) {
            buf.append(m.group()).append('\n');
        }
        return buf.toString()
                  .replace("html2","html");
    }

    String comment(String in, int b) { // ... extends DOMTestCase
        var q = in.lastIndexOf("*/",b);
        var p = in.lastIndexOf("/*",q);
        var s = in.substring(p,q+2);
        s = stars.reset(s).replaceAll("\n* ");
        return s;
    }

    Matcher stars = Pattern.compile("\n *\\* +",Pattern.DOTALL).matcher("");

    String setUp(String in, int c, int d) { // final DOMTestDocumentBuilderFactory ... void runTest()
        var p = in.indexOf('{',c);
        var q = in.lastIndexOf('}',d);
        var s = in.substring(p,q+1);
        s = cleanup(s);
        return body(s);
    }

    String runTest(String in, int d, int e) { // void runTest() ... String getTargetURI()
        var p = in.indexOf('{',d);
        var q = in.lastIndexOf('}',e);
        var s = in.substring(p,q+1);
        s = javaUtil.reset(s).replaceAll("");
        s = fixAutoCase(s);
        s = fixAsserts(s);
        s = fixHtml(s);
        return body(s);
    }

    String body(String s) {
        s = leading.reset(s).replaceAll("\n  ");
        s = empty.reset(s).replaceAll("");
        s = closing.reset(s).replaceFirst(" }");
        return s;
    }

    Matcher leading = Pattern.compile("\n *",Pattern.DOTALL).matcher("");
    Matcher empty   = Pattern.compile("\n *\n",Pattern.DOTALL).matcher("");
    Matcher closing = Pattern.compile("  }$").matcher("");

    String getTargetURI(String in, int e) {
        var p = in.indexOf('"',e);
        var q = in.indexOf('"',p+1)+1;
        return in.substring(p,q).replace('-','_');
    }

    String cleanup(String s) {
        s = settings.reset(s).replaceFirst("");
        s = setFactory.reset(s).replaceFirst("");
        s = superFactory.reset(s).replaceFirst("");
        s = featureXML.reset(s).replaceFirst("\n  feature(\"XML\");\n");
        s = slashes.reset(s).replaceAll("");
        s = notes.reset(s).replaceAll("  // ");
        s = fixConfig(s);
        return s;
    }

    Matcher settings = Pattern.compile(
        " *org\\.w3c\\.domts\\.DocumentBuilderSetting\\[\\] settings = \n" +
        " *new org\\.w3c\\.domts\\.DocumentBuilderSetting\\[\\] \\{\n" ,
        Pattern.DOTALL ).matcher("");

    Matcher setFactory = Pattern.compile(
        " *\\};\n" +
        " *DOMTestDocumentBuilderFactory testFactory = factory\\.newInstance\\(settings\\);\n" +
        " *setFactory\\(testFactory\\);\n" ,
        Pattern.DOTALL ).matcher("");

    Matcher superFactory = Pattern.compile(
        " *super\\(factory\\);" ).matcher("");

    Matcher featureXML = Pattern.compile(
        " *if \\(factory\\.hasFeature\\(\"XML\", null\\) != true\\) \\{\n" +
        " *throw org\\.w3c\\.domts\\.DOMTestIncompatibleException\\.incompatibleFeature\\(\"XML\", null\\);\n" +
        " *}" ,
        Pattern.DOTALL ).matcher("");

    Matcher slashes = Pattern.compile(" *//\n",Pattern.DOTALL).matcher("");
    Matcher notes = Pattern.compile(" *// *",Pattern.DOTALL).matcher("");

    Matcher javaUtil = Pattern.compile("java\\.util\\.").matcher("");

    Matcher dbs = Pattern.compile(
        "org\\.w3c\\.domts\\.DocumentBuilderSetting\\.(\\w*),?").matcher("");

    String fixConfig(String s) {
        var buf = new StringBuilder();
        var m = dbs.reset(s);
        var p = 0;
        while (m.find(p)) {
           var a = m.start();
           var t = parserSetting(m.group(1));
           buf.append(s.subSequence(p,a)).append("\n  ").append(t).append(";\n");
           p = m.end();
        }
        buf.append(s.subSequence(p,s.length()));
        return buf.toString();
    }

    String parserSetting(String s) {
        return switch (s) {
            case "namespaceAware" -> "setNamespaceAware(true)";
            case "notNamespaceAware" -> "setNamespaceAware(false)";
            case "validating" -> "setValidating(true)";
            case "notValidating" -> "setValidating(false)";
            case "notCoalescing" -> "setCoalescing(false)";
            case "notExpandEntityReferences" -> "setExpandEntityReferences(false)";
            case "signed" -> "feature(\"signed\")";
            case "hasNullString" -> "feature(\"hasNullString\")";
            default -> s;
        };
    }

    Matcher eac = Pattern.compile("assertEqualsAutoCase\\(\"(\\w+)\", \"(\\w+)\", ").matcher("");

    String fixAutoCase(String s) {
        s = eac.reset(s).replaceAll("assertEqualsAutoCase(\"$2\", \"$1\", ");
        return s;
    }

    Matcher asrt = Pattern.compile("\n *assert",Pattern.DOTALL).matcher("");

    String fixAsserts(String s) {
        var buf = new StringBuilder();
        var m = asrt.reset(s);
        var p = 0;
        while (m.find(p)) {
            var a = s.indexOf("assert",m.start()); // assert...
            var b = s.indexOf('(',a); // ...(...
            var c = s.indexOf(");",b); // ...);
            var condition = s.substring(a+6,b);
            var equals = equiv(condition);
            String args, close, separator, msg;
            if (equals.isEmpty()) {
                close = "";
            } else {
                equals = ' '+equals+'(';
                close = " )";
                condition = "True";
            }
            var d = b+1;
            if (s.charAt(d) == '"') {
                var e = s.indexOf('"',d+1)+1;
                var f = e+1;
                msg = s.substring(d,e)+' ';
                separator = s.substring(e,f)+' ';
                args = ' '+s.substring(f,c).trim();
            } else {
                separator = msg = "";
                args = s.substring(d,c);
            }
            buf.append(s.subSequence(p,a))
               .append("assert").append(condition).append('(')
               .append(equals).append(args).append(close)
               .append(separator).append(msg);
            p = c;
        }
        buf.append(s.subSequence(p,s.length()));
        return buf.toString();
    }

    String equiv(String f) {
        return switch (f) {
            case "Size" -> "equalsSize";
            case "URIEquals" -> "equalsURI";
            case "EqualsAutoCase" -> "equalsAutoCase";
            case "EqualsIgnoreCase" -> "equalsIgnoreCase";
            case "InstanceOf" -> "instanceOf";
            default -> "";
        };
    }

    Matcher opts = Pattern.compile("HTMLOptionsCollection").matcher("");

    Matcher vint = Pattern.compile(
        "v(hspace|vspace|height|width|size) = \\(int\\) " +
        "(\\(\\(HTML(?:Applet|Image|Object|BaseFont|Input).*?);" ).matcher("");

    String fixHtml(String s) {
        s = opts.reset(s).replaceAll("HTMLCollection");
        s = vint.reset(s).replaceAll("v$1 = Integer.parseInt( $2 );");
        return s;
    }

}
