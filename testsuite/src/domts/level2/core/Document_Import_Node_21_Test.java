package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The importNode method imports a node from another document to this document. 
* The returned node has no parent; (parentNode is null). The source node is not 
* altered or removed from the original document but a new copy of the source node
* is created.
* 
* Using the method importNode with deep=true, retreive the entity refs present in the 
* second element node whose tagName is address and import these nodes into another document. 
* Verify if the nodes have been imported correctly by checking the nodeNames of the 
* imported nodes, since they are imported into a new document which doesnot have thes defined,
* the imported nodes should not have any children.
* Now import the entityRef nodes into the same document and verify if the nodes have been 
* imported correctly by checking the nodeNames of the imported nodes, and by checking the 
* value of the replacement text of the imported nodes.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core">http://www.w3.org/TR/DOM-Level-2-Core/core</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
*/
@Disabled("2")
class Document_Import_Node_21_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  setExpandEntityReferences(false);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/documentimportnode21")
 void run() throws Throwable {
  Document doc;
  DocumentType docTypeNull = null;
  Document docImp;
  DOMImplementation domImpl;
  NodeList addressList;
  NodeList addressChildList;
  Element element;
  EntityReference entRef2;
  EntityReference entRefImp2;
  EntityReference entRef3;
  EntityReference entRefImp3;
  String nodeName2;
  String nodeName3;
  String nodeNameImp2;
  String nodeNameImp3;
  NodeList nodes;
  Node nodeImp3;
  Node nodeImp2;
  String nodeValueImp2;
  String nodeValueImp3;
  doc = (Document) load("staffNS", true);
  domImpl = doc.getImplementation();
  docImp = domImpl.createDocument("http://www.w3.org/DOM/Test", "a:b", docTypeNull);
  addressList = doc.getElementsByTagName("address");
  element = (Element) addressList.item(1);
  addressChildList = element.getChildNodes();
  entRef2 = (EntityReference) addressChildList.item(0);
  entRef3 = (EntityReference) addressChildList.item(2);
  entRefImp2 = (EntityReference) docImp.importNode(entRef2, true);
  entRefImp3 = (EntityReference) docImp.importNode(entRef3, false);
  nodeName2 = entRef2.getNodeName();
  nodeName3 = entRef3.getNodeName();
  nodeNameImp2 = entRefImp2.getNodeName();
  nodeNameImp3 = entRefImp3.getNodeName();
  assertEquals(nodeName2, nodeNameImp2, "documentimportnode21_Ent2NodeName");
  assertEquals(nodeName3, nodeNameImp3, "documentimportnode21_Ent3NodeName");
  entRefImp2 = (EntityReference) doc.importNode(entRef2, true);
  entRefImp3 = (EntityReference) doc.importNode(entRef3, false);
  nodes = entRefImp2.getChildNodes();
  nodeImp2 = nodes.item(0);
  nodeValueImp2 = nodeImp2.getNodeValue();
  nodes = entRefImp3.getChildNodes();
  nodeImp3 = nodes.item(0);
  nodeValueImp3 = nodeImp3.getNodeValue();
  assertEquals("1900 Dallas Road", nodeValueImp2, "documentimportnode21_Ent2NodeValue");
  assertEquals("Texas", nodeValueImp3, "documentimportnode21_Ent3Nodevalue");
 }
}