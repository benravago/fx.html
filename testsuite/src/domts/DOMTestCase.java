package domts;

import java.io.InputStream;
import java.util.Collection;
import java.util.function.BiPredicate;
import java.util.function.Function;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

public abstract class DOMTestCase implements Function<String,InputStream> {

    private DOMTestDocumentService service = DOMTestDocumentService.getInstance();

    public boolean isCoalescing() { return service.isCoalescing(); }
    public boolean isExpandEntityReferences() { return service.isExpandEntityReferences(); }
    public boolean isIgnoringComments() { return service.isIgnoringComments(); }
    public boolean isIgnoringElementContentWhitespace() { return service.isIgnoringElementContentWhitespace(); }
    public boolean isNamespaceAware() { return service.isNamespaceAware(); }
    public boolean isValidating() { return service.isValidating(); }

    public void setCoalescing(boolean coalescing) { service.setCoalescing(coalescing); }
    public void setExpandEntityReferences(boolean expandEntityRef) { service.setExpandEntityReferences(expandEntityRef); }
    public void setIgnoringComments(boolean ignoreComments) { service.setIgnoringComments(ignoreComments); }
    public void setIgnoringElementContentWhitespace(boolean whitespace) { service.setIgnoringElementContentWhitespace(whitespace); }
    public void setNamespaceAware(boolean awareness) { service.setNamespaceAware(awareness); }
    public void setValidating(boolean validating) { service.setValidating(validating); }

    public String getContentType() { return service.getContentType(); }
    
    public DOMImplementation getImplementation() throws Exception { return service.getImplementation(); }
    public Document load(String docURI, boolean willBeModified) throws Exception { return service.parse(docURI,this); }

    @Override
    public InputStream apply(String systemId) {
        var rn = resourceName(systemId);
        return getClass().getResourceAsStream(rn);
    }

    String resourceName(String uri) {
        var p = uri.lastIndexOf('/'); // get filename part
        var n = p < 0 ? uri : uri.substring(p+1);
        if (n.indexOf('.') < 0) n = n + service.getFileType();
        return "resource/" + n;
    }

    protected void feature(String uri) {
        // no-op
    }

    protected void preload(String contentType, String docURI, boolean willBeModified) {
        // System.out.println(this+" using "+service+" for "+contentType+' '+docURI);
    }

    // Test support api

    public static boolean equals(int a, int b) { return a == b; }
    public static boolean equals(String a, String b) { return a.equals(b); }

    public boolean equalsIgnoreCase(String expected, String actual) {
        return expected.equalsIgnoreCase(actual);
    }

    public boolean equalsAutoCase(String context, String expected, String actual) {
        var contentType = getContentType();
        if ("text/html".equals(contentType)) {
            // if the content type is HTML (not XHTML)
            if ("attribute".equals(context)) {
                // if the context is attribute, then use case-insensitive comparison
                return expected.equalsIgnoreCase(actual);
            } else {
                // otherwise should be compared against upper-cased expectation
                return expected.toUpperCase().equals(actual.toUpperCase());
            }
        } else {
            return expected.equals(actual);
        }
    }

    public boolean equalsAutoCase(String context, Collection<?> expected, Collection<?> actual) {
        var contentType = getContentType();
        if ("text/html".equals(contentType)) {
            if ("attribute".equals(context)) {
                return equalsIgnoreCase(expected,actual);
            } else {
                return equalsUpperCase(expected,actual);
            }
        } else {
            return equalsApplyCase(expected,actual);
        }
    }

    public static boolean equalsApplyCase(Collection<?> expected, Collection<?> actual) {
        return compare(expected, actual, (t,u) -> String.valueOf(t).equals(String.valueOf(u)) );
    }
    public static boolean equalsIgnoreCase(Collection<?> expected, Collection<?> actual) {
        return compare(expected, actual, (t,u) -> String.valueOf(t).equalsIgnoreCase(String.valueOf(u)) );
    }
    public static boolean equalsUpperCase(Collection<?> expected, Collection<?> actual) {
        return compare(expected, actual, (t,u) -> String.valueOf(t).toUpperCase().equals(String.valueOf(u).toUpperCase()) );
    }

    static <T,U> boolean compare(Collection<T> a, Collection<U> b, BiPredicate<T,U> cmp) {
        if (a.isEmpty() && b.isEmpty()) return true;
        if (a.size() != b.size()) return false;
        A: for (var t:a) { // for each item in A
            B: for (var u:b) { // find it in B
                if (cmp.test(t,u)) continue A; // matched item A in B
            }
            return false; // no match for item A in B
        }
        return true; // all items A were matched in B
    }

    public static boolean equalsSize(int size, NodeList list) { return size == list.getLength(); }
    public static boolean equalsSize(int size, NamedNodeMap map) { return size == map.getLength(); }

    public boolean instanceOf(Class<?> cls, Object obj) { return cls.isInstance(obj); }

    public boolean equalsURI(String scheme, String path, String host, String file, String name, String query, String fragment, Boolean isAbsolute, String actual) {
        return false; // TODO:
    }

}

/*

  public void assertURIEquals(
      String assertID,
      String scheme,
      String path,
      String host,
      String file,
      String name,
      String query,
      String fragment,
      Boolean isAbsolute,
      String actual) {
    //
    //  URI must be non-null
    assertNotNull(assertID, actual);

    String uri = actual;

    int lastPound = actual.lastIndexOf("#");
    String actualFragment = "";
    if (lastPound != -1) {
      //
      //   substring before pound
      //
      uri = actual.substring(0, lastPound);
      actualFragment = actual.substring(lastPound + 1);
    }
    if (fragment != null) {
      assertEquals(assertID, fragment, actualFragment);

    }
    int lastQuestion = uri.lastIndexOf("?");
    String actualQuery = "";
    if (lastQuestion != -1) {
      //
      //   substring before pound
      //
      uri = actual.substring(0, lastQuestion);
      actualQuery = actual.substring(lastQuestion + 1);
    }
    if (query != null) {
      assertEquals(assertID, query, actualQuery);

    }
    int firstColon = uri.indexOf(":");
    int firstSlash = uri.indexOf("/");
    String actualPath = uri;
    String actualScheme = "";
    if (firstColon != -1 && firstColon < firstSlash) {
      actualScheme = uri.substring(0, firstColon);
      actualPath = uri.substring(firstColon + 1);
    }

    if (scheme != null) {
      assertEquals(assertID, scheme, actualScheme);
    }

    if (path != null) {
      assertEquals(assertID, path, actualPath);
    }

    if (host != null) {
      String actualHost = "";
      if (actualPath.startsWith("//")) {
        int termSlash = actualPath.indexOf("/", 2);
        actualHost = actualPath.substring(0, termSlash);
      }
      assertEquals(assertID, host, actualHost);
    }

    String actualFile = actualPath;
    if (file != null || name != null) {
      int finalSlash = actualPath.lastIndexOf("/");
      if (finalSlash != -1) {
        actualFile = actualPath.substring(finalSlash + 1);
      }
      if (file != null) {
        assertEquals(assertID, file, actualFile);
      }
    }

    if (name != null) {
      String actualName = actualFile;
      int finalPeriod = actualFile.lastIndexOf(".");
      if (finalPeriod != -1) {
        actualName = actualFile.substring(0, finalPeriod);
      }
      assertEquals(assertID, name, actualName);
    }

    if (isAbsolute != null) {
      //
      //   Jar URL's will have any actual path like file:/c:/somedrive...
      assertEquals(
          assertID,
          isAbsolute.booleanValue(),
          actualPath.startsWith("/") || actualPath.startsWith("file:/"));
    }
  }
 */
