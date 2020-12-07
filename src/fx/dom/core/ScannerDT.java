package fx.dom.core;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.stream.XMLResolver;
import javax.xml.stream.events.DTD;

public class ScannerDT extends Scanner {

    @Override
    public void setResolver(XMLResolver resolver) {
        if (resolver != null) resolver = wrap(resolver);
        super.setResolver(resolver);
    }

    XMLResolver wrap(XMLResolver xr) {
        return (publicId, systemId, baseURI, namespace) -> {
            try {
                var in = xr.resolveEntity(publicId,systemId,baseURI,namespace);
                if (in instanceof InputStream) {
                    var b = ((InputStream)in).readAllBytes();
                    resolvedEntities.put(systemId,b);
                    return new ByteArrayInputStream(b);
                }
            } catch (IOException ignore) {}
            return null;
        };
    }

    Map<String,byte[]> resolvedEntities = new HashMap<>();

    @Override
    protected void dtd(DTD d) {
        super.dtd(d);
        parseDecl(d.getDocumentTypeDeclaration());
        for (var k:resolvedEntities.keySet()) {
            parseDecl(new String(resolvedEntities.remove(k)));
        }
    }

    // A basic DTD parser to complement XMLEventReader's DTD handler.
    // Only scans for <!ELEMENT ... > and <!ATTLIST ...> and does no validation.
    // see https://www.w3.org/TR/REC-xml/#dt-doctype

    char[] ch;
    int m, p;

    void parseDecl(String in) {
        ch = in.toCharArray();
        p = 0;
        m = ch.length;

        while (next()) {
            if (eq("ELEMENT")) elementDecl();
            else if (eq("ATTLIST")) attlistDecl();
        }
    }

    // to next '<!'
    boolean next() {
        var n = m - 2;
        while (p < n) {
            if (ch[p] == '<' && ch[p+1] == '!') {
                p += 2;
                return true;
            }
            p++;
        }
        return false;
    }

    // to next '>'
    void skip() {
        while (p < m) {
            if (ch[p] == '>') return;
            p++;
        }
    }

    // match s at p
    boolean eq(String s) {
        var n = s.length();
        for (var i = 0; i < n; i++) {
            if (ch[p+i] != s.charAt(i)) return false;
        }
        p += n;
        return true;
    }

    /**
     *  elementdecl  ::= '<!ELEMENT' S Name S contentspec S? '>'
     */
    void elementDecl() {
        var b = p;
        skip();
        var s = new String(ch,b,p-b).split("\\s+",3);
        elementDeclaration(s[1],s[2]);
    }

    /**
     *  attlistDecl  ::= '<!ATTLIST' S Name attDef* S? '>'
     *  attDef       ::= S Name S AttType S DefaultDecl
     */
    void attlistDecl() {
        var b = p;
        skip();
        var s = new String(ch,b,p-b).split("\\s+");
        var eName = s[1];
        var i = 2;
        while (i < s.length) {
            var aName = s[i++];
            var type = s[i++];
            //  mode
            var value = s[i++];
            attributeDeclaration(eName,aName,type,null,value);
        }
    }

    protected void elementDeclaration(String name, String model) {}
    protected void attributeDeclaration(String eName, String aName, String type, String mode, String value) {}

}
