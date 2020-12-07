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
* Using the method importNode with deep=true/false, import two notaiton nodes into the 
* same and different documnet objects.  In each case check if valid public and systemids 
* are returned if any and if none, check if a null value was returned.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core">http://www.w3.org/TR/DOM-Level-2-Core/core</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
*/
class Document_Import_Node_22_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/documentimportnode22")
 void run() throws Throwable {
  Document doc;
  DocumentType docTypeNull = null;
  Document docImp;
  DOMImplementation domImpl;
  DocumentType docType;
  NamedNodeMap nodeMap;
  Notation notation1;
  Notation notation2;
  Notation notationImp1;
  Notation notationImp2;
  Notation notationImpNew1;
  Notation notationImpNew2;
  String publicId1;
  String publicId1Imp;
  String publicId1NewImp;
  String publicId2Imp;
  String publicId2NewImp;
  String systemId1Imp;
  String systemId1NewImp;
  String systemId2;
  String systemId2Imp;
  String systemId2NewImp;
  doc = (Document) load("staffNS", true);
  domImpl = doc.getImplementation();
  docType = doc.getDoctype();
  docImp = domImpl.createDocument("http://www.w3.org/DOM/Test", "a:b", docTypeNull);
  nodeMap = docType.getNotations();
  assertNotNull(nodeMap, "notationsNotNull");
  notation1 = (Notation) nodeMap.getNamedItem("notation1");
  notation2 = (Notation) nodeMap.getNamedItem("notation2");
  notationImp1 = (Notation) doc.importNode(notation1, true);
  notationImp2 = (Notation) doc.importNode(notation2, false);
  notationImpNew1 = (Notation) docImp.importNode(notation1, false);
  notationImpNew2 = (Notation) docImp.importNode(notation2, true);
  publicId1 = notation1.getPublicId();
  publicId1Imp = notation1.getPublicId();
  publicId1NewImp = notation1.getPublicId();
  systemId1Imp = notation1.getSystemId();
  systemId1NewImp = notation1.getSystemId();
  publicId2Imp = notation2.getPublicId();
  publicId2NewImp = notation2.getPublicId();
  systemId2 = notation2.getSystemId();
  systemId2Imp = notation2.getSystemId();
  systemId2NewImp = notation2.getSystemId();
  assertEquals(publicId1, publicId1Imp, "documentimportnode22_N1PID");
  assertEquals(publicId1, publicId1NewImp, "documentimportnode22_N1NPID");
  assertNull(systemId1Imp, "documentimportnode22_N1SID");
  assertNull(systemId1NewImp, "documentimportnode22_N1NSID");
  assertEquals(systemId2, systemId2Imp, "documentimportnode22_N2SID");
  assertEquals(systemId2, systemId2NewImp, "documentimportnode22_N2NSID");
  assertNull(publicId2Imp, "documentimportnode22_N2PID");
  assertNull(publicId2Imp, "documentimportnode22_N2NPID");
 }
}