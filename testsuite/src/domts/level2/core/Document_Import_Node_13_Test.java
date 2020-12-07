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
* Using the method importNode with deep=false, import the first employee element node of this
* Document.  Verify if the node has been imported correctly by checking the length of the
* this elements childNode list before and after the import.  
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core">http://www.w3.org/TR/DOM-Level-2-Core/core</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
*/
class Document_Import_Node_13_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/documentimportnode13")
 void run() throws Throwable {
  Document doc;
  NodeList childList;
  Node imported;
  NodeList importedList;
  Node employeeElem;
  int importedLen;
  doc = (Document) load("staffNS", true);
  childList = doc.getElementsByTagNameNS("*", "employee");
  employeeElem = childList.item(0);
  imported = doc.importNode(employeeElem, false);
  importedList = imported.getChildNodes();
  importedLen = (int) importedList.getLength();
  assertEquals(0, importedLen, "documentimportnode13");
 }
}