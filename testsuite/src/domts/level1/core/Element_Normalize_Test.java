package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "normalize()" method puts all the nodes in the full
* depth of the sub-tree underneath this element into a 
* "normal" form. 
* 
* Retrieve the third employee and access its second child.
* This child contains a block of text that is spread 
* across multiple lines.  The content of the "name" child
* should be parsed and treated as a single Text node.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-162CF083">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-162CF083</a>
*/
class Element_Normalize_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/elementnormalize")
 void run() throws Throwable {
  Document doc;
  Element root;
  NodeList elementList;
  Element testName;
  Node firstChild;
  String childValue;
  doc = (Document) load("staff", true);
  root = doc.getDocumentElement();
  root.normalize();
  elementList = root.getElementsByTagName("name");
  testName = (Element) elementList.item(2);
  firstChild = testName.getFirstChild();
  childValue = firstChild.getNodeValue();
  assertEquals("Roger\n Jones", childValue, "elementNormalizeAssert");
 }
}