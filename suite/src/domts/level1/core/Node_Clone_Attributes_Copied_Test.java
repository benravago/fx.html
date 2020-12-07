package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* If the cloneNode method is used to clone an
* Element node, all the attributes of the Element are
* copied along with their values.
* 
* Retrieve the last child of the second employee and invoke
* the cloneNode method.   The
* duplicate node returned by the method should copy the
* attributes associated with this node.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096</a>
*/
@Disabled("fx")
class Node_Clone_Attributes_Copied_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodecloneattributescopied")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node addressNode;
  Node clonedNode;
  NamedNodeMap attributes;
  Node attributeNode;
  String attributeName;
  Collection result = new ArrayList();
  Collection expectedResult = new ArrayList();
  expectedResult.add("domestic");
  expectedResult.add("street");
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("address");
  addressNode = elementList.item(1);
  clonedNode = addressNode.cloneNode(false);
  attributes = clonedNode.getAttributes();
  for (int indexN10065 = 0; indexN10065 < attributes.getLength(); indexN10065++) {
   attributeNode = (Node) attributes.item(indexN10065);
   attributeName = attributeNode.getNodeName();
   result.add(attributeName);
  }
  assertEquals(expectedResult, result, "nodeCloneAttributesCopiedAssert1");
 }
}