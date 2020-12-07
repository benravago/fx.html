package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getAttributes()" method invoked on an EntityReference 
* Node returns null.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096</a>
*/
class Node_EntityReference_Node_Attributes_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodeentityreferencenodeattributes")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element entRefAddr;
  Node entRefNode;
  NamedNodeMap attrList;
  int nodeType;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("address");
  entRefAddr = (Element) elementList.item(1);
  entRefNode = entRefAddr.getFirstChild();
  nodeType = (int) entRefNode.getNodeType();
  if (!equals(5, nodeType)) {
   entRefNode = doc.createEntityReference("ent2");
   assertNotNull(entRefNode, "createdEntRefNotNull");
  }
  attrList = entRefNode.getAttributes();
  assertNull(attrList, "attrList");
 }
}