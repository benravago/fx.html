package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getAttributes()" method invoked on a Text
* Node returns null.
* Retrieve the Text node from the last child of the
* first employee and invoke the "getAttributes()" method
* on the Text Node.  It should return null.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1312295772">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1312295772</a>
*/
class Node_Text_Node_Attribute_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodetextnodeattribute")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node testAddr;
  Node textNode;
  NamedNodeMap attrList;
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("address");
  testAddr = elementList.item(0);
  textNode = testAddr.getFirstChild();
  attrList = textNode.getAttributes();
  assertNull(attrList, "nodeTextNodeAttributesAssert1");
 }
}