package domts.level2.core;
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
* across multiple lines.   The content of the "name" child
* should be parsed and treated as a single Text node.
* This appears to be a duplicate of elementnormalize.xml in DOM L1 Test Suite
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-normalize">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-normalize</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-72AB8359">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-72AB8359</a>
*/
class Normalize_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/normalize01")
 void run() throws Throwable {
  Document doc;
  Element root;
  NodeList elementList;
  Node firstChild;
  NodeList textList;
  CharacterData textNode;
  String data;
  doc = (Document) load("staff", false);
  root = doc.getDocumentElement();
  root.normalize();
  elementList = root.getElementsByTagName("name");
  firstChild = elementList.item(2);
  textList = firstChild.getChildNodes();
  textNode = (CharacterData) textList.item(0);
  data = textNode.getData();
  assertEquals("Roger\n Jones", data, "data");
 }
}