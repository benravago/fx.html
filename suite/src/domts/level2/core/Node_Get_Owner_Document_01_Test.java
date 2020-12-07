package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method getOwnerDocument returns the Document object associated with this node
* 
* Create a new DocumentType node.  Since this node is not used with any Document yet
* verify if the ownerDocument is null.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#node-ownerDoc">http://www.w3.org/TR/DOM-Level-2-Core/core#node-ownerDoc</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=259">http://www.w3.org/Bugs/Public/show_bug.cgi?id=259</a>
*/
class Node_Get_Owner_Document_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/nodegetownerdocument01")
 void run() throws Throwable {
  Document doc;
  Document ownerDoc;
  DOMImplementation domImpl;
  DocumentType docType;
  String nullID = null;
  doc = (Document) load("staff", false);
  domImpl = doc.getImplementation();
  docType = domImpl.createDocumentType("mydoc", nullID, nullID);
  ownerDoc = docType.getOwnerDocument();
  assertNull(ownerDoc, "nodegetownerdocument01");
 }
}