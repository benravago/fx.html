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
* Using the method importNode with deep=true, import a entity node ent4 
* from this document to a new document object.  The replacement text of this entity is an element
* node, a cdata node and a pi.  Verify if the nodes have been 
* imported correctly by checking the nodeNames of the imported element node, the data for the
* cdata nodes and the PItarget and PIData for the pi nodes.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core">http://www.w3.org/TR/DOM-Level-2-Core/core</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
*/
@Disabled("2")
class Document_Import_Node_20_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  setExpandEntityReferences(false);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/documentimportnode20")
 void run() throws Throwable {
  Document doc;
  Document docImp;
  DOMImplementation domImpl;
  DocumentType docType;
  DocumentType docTypeNull = null;
  NamedNodeMap nodeMap;
  Entity entity4;
  Entity entityImp4;
  Element element;
  CharacterData cdata;
  ProcessingInstruction pi;
  NodeList childList;
  NodeList elemchildList;
  String ent4Name;
  String ent4ImpName;
  String cdataVal;
  String piTargetVal;
  String piDataVal;
  doc = (Document) load("staffNS", true);
  domImpl = doc.getImplementation();
  docType = doc.getDoctype();
  docImp = domImpl.createDocument("http://www.w3.org/DOM/Test", "a:b", docTypeNull);
  nodeMap = docType.getEntities();
  entity4 = (Entity) nodeMap.getNamedItem("ent4");
  entityImp4 = (Entity) docImp.importNode(entity4, true);
  childList = entityImp4.getChildNodes();
  element = (Element) childList.item(0);
  elemchildList = element.getChildNodes();
  cdata = (CharacterData) elemchildList.item(0);
  pi = (ProcessingInstruction) childList.item(1);
  ent4Name = entity4.getNodeName();
  ent4ImpName = entityImp4.getNodeName();
  cdataVal = cdata.getData();
  piTargetVal = pi.getTarget();
  piDataVal = pi.getData();
  assertEquals(ent4Name, ent4ImpName, "documentimportnode20_Ent4NodeName");
  assertEquals("Element data", cdataVal, "documentimportnode20_Cdata");
  assertEquals("PItarget", piTargetVal, "documentimportnode20_PITarget");
  assertEquals("PIdata", piDataVal, "documentimportnode20_PIData");
 }
}