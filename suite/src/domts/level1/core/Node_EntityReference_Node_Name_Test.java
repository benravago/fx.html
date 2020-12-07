package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The string returned by the "getNodeName()" method for an 
* EntityReference Node is the name of the entity referenced.
* 
* Retrieve the first Entity Reference node from the last
* child of the second employee and check the string 
* returned by the "getNodeName()" method.   It should be 
* equal to "ent2". 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095</a>
*/
class Node_EntityReference_Node_Name_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodeentityreferencenodename")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element entRefAddr;
  Node entRefNode;
  String entRefName;
  int nodeType;
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("address");
  entRefAddr = (Element) elementList.item(1);
  entRefNode = entRefAddr.getFirstChild();
  nodeType = (int) entRefNode.getNodeType();
  if (!equals(5, nodeType)) {
   entRefNode = doc.createEntityReference("ent2");
   assertNotNull(entRefNode, "createdEntRefNotNull");
  }
  entRefName = entRefNode.getNodeName();
  assertEquals("ent2", entRefName, "nodeEntityReferenceNodeNameAssert1");
 }
}