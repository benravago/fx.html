package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getAttributes()" method invoked on an Element
* Node returns a NamedNodeMap containing the attributes
* of this node.
* 
* Retrieve the last child of the third employee and
* invoke the "getAttributes()" method.   It should return
* a NamedNodeMap containing the attributes of the Element
* node. 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096</a>
*/
@Disabled("fx")
class Node_Element_Node_Attributes_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodeelementnodeattributes")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testAddr;
  NamedNodeMap addrAttr;
  Node attrNode;
  String attrName;
  Collection attrList = new ArrayList();
  Collection expected = new ArrayList();
  expected.add("domestic");
  expected.add("street");
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("address");
  testAddr = (Element) elementList.item(2);
  addrAttr = testAddr.getAttributes();
  for (int indexN1005C = 0; indexN1005C < addrAttr.getLength(); indexN1005C++) {
   attrNode = (Node) addrAttr.item(indexN1005C);
   attrName = attrNode.getNodeName();
   attrList.add(attrName);
  }
  assertEquals(expected, attrList, "nodeElementNodeValueAssert1");
 }
}