package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getNodeType()" method for an EntityReference Node
* returns the constant value 5.
* 
* Retrieve the EntityReference node from the last child
* of the second employee and invoke the "getNodeType()"   
* method.   The method should return 5. 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-111237558">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-111237558</a>
*/
class Node_EntityReference_Node_Type_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodeentityreferencenodetype")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element entRefAddr;
  Node entRefNode;
  int nodeType;
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("address");
  entRefAddr = (Element) elementList.item(1);
  entRefNode = entRefAddr.getFirstChild();
  nodeType = (int) entRefNode.getNodeType();
  if (equals(3, nodeType)) {
   entRefNode = doc.createEntityReference("ent2");
   assertNotNull(entRefNode, "createdEntRefNotNull");
   nodeType = (int) entRefNode.getNodeType();
  }
  assertEquals(5, nodeType, "entityNodeType");
 }
}