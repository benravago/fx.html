package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The version attribute specifies version information about the document's
* DTD. 
* Retrieve the version attribute and examine its value.  
* Test is only applicable to HTML, version attribute is not supported in XHTML.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-9383775">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-9383775</a>
*/
class HTML_Html_Element_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "html", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLHtmlElement01")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vversion;
  Document doc;
  doc = (Document) load("html", false);
  nodeList = doc.getElementsByTagName("html");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vversion = ((HTMLHtmlElement) /*Node */testNode).getVersion();
  if (("text/html".equals(getContentType()))) {
   assertEquals("-//W3C//DTD HTML 4.01 Transitional//EN", vversion, "versionLink");
  }
 }
}