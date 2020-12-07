package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method getOwnerDocument returns the Document object associated with this node
* 
* Create a new Document node.  Since this node is not used with any Document yet
* verify if the ownerDocument is null.  Create a new element Node on the new Document
* object.  Check the ownerDocument of the new element node.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#node-ownerDoc">http://www.w3.org/TR/DOM-Level-2-Core/core#node-ownerDoc</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=259">http://www.w3.org/Bugs/Public/show_bug.cgi?id=259</a>
*/
class Node_Get_Owner_Document_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/nodegetownerdocument02")
 void run() throws Throwable {
  Document doc;
  Document newDoc;
  Element newElem;
  Document ownerDocDoc;
  Document ownerDocElem;
  DOMImplementation domImpl;
  DocumentType docType;
  String nullNS = null;
  doc = (Document) load("staff", false);
  domImpl = doc.getImplementation();
  docType = domImpl.createDocumentType("mydoc", nullNS, nullNS);
  newDoc = domImpl.createDocument("http://www.w3.org/DOM/Test", "mydoc", docType);
  ownerDocDoc = newDoc.getOwnerDocument();
  assertNull(ownerDocDoc, "nodegetownerdocument02_1");
  newElem = newDoc.createElementNS("http://www.w3.org/DOM/Test", "myelem");
  ownerDocElem = newElem.getOwnerDocument();
  assertNotNull(ownerDocElem, "nodegetownerdocument02_2");
 }
}