package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The href attribute specifies the URI of the linked resource.     
* Retrieve the href attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-33532588">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-33532588</a>
*/
class HTML_Link_Element_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "link", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLLinkElement03")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vhref;
  Document doc;
  doc = (Document) load("link", false);
  nodeList = doc.getElementsByTagName("link");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(0);
  vhref = ((HTMLLinkElement) /*Node */testNode).getHref();
  assertTrue(equalsURI(null, null, null, "glossary.html", null, null, null, null, vhref), "hrefLink");
 }
}