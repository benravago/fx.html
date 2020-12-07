package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The href attribute specifies the base URI. 
* Retrieve the href attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-65382887">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-65382887</a>
*/
class HTML_Base_Element_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "base", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLBaseElement01")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vhref;
  Document doc;
  doc = (Document) load("base", false);
  nodeList = doc.getElementsByTagName("base");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vhref = ((HTMLBaseElement) /*Node */testNode).getHref();
  assertEquals("about:blank", vhref, "hrefLink");
 }
}