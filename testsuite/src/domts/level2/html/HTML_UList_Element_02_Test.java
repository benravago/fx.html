package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The type attribute specifies the bullet style.      
* Retrieve the type attribute and examine its value.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-96874670">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-96874670</a>
*/
class HTML_UList_Element_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "ulist", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLUListElement02")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vtype;
  Document doc;
  doc = (Document) load("ulist", false);
  nodeList = doc.getElementsByTagName("ul");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(0);
  vtype = ((HTMLUListElement) /*Node */testNode).getType();
  assertEquals("disc", vtype, "typeLink");
 }
}