package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getAttributes()" method invoked on an Attribute
* Node returns null.
* Retrieve the first attribute from the last child of the
* first employee and invoke the "getAttributes()" method
* on the Attribute Node.  It should return null.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-637646024">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-637646024</a>
*/
class Node_Attribute_Node_Attribute_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodeattributenodeattribute")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testAddr;
  NamedNodeMap addrAttr;
  Node attrNode;
  NamedNodeMap attrList;
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("address");
  testAddr = (Element) elementList.item(0);
  addrAttr = testAddr.getAttributes();
  attrNode = addrAttr.item(0);
  attrList = attrNode.getAttributes();
  assertNull(attrList, "nodeAttributeNodeAttributeAssert1");
 }
}