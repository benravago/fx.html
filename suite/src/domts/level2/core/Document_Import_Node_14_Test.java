package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Using the method importNode with deep=true, import the fourth employee element node of this
* Document.  Verify if the node has been imported correctly by checking 
* if the default attribute present on this node has not been imported
* and an explicit attribute has been imported.  
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core">http://www.w3.org/TR/DOM-Level-2-Core/core</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=259">http://www.w3.org/Bugs/Public/show_bug.cgi?id=259</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=402">http://www.w3.org/Bugs/Public/show_bug.cgi?id=402</a>
*/
class Document_Import_Node_14_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/documentimportnode14")
 void run() throws Throwable {
  Document doc;
  Document newDoc;
  DOMImplementation domImpl;
  DocumentType nullDocType = null;
  NodeList childList;
  Node imported;
  Node employeeElem;
  Attr attrNode;
  String attrValue;
  String nullNS = null;
  doc = (Document) load("staffNS", true);
  childList = doc.getElementsByTagNameNS("*", "employee");
  employeeElem = childList.item(3);
  domImpl = getImplementation();
  newDoc = domImpl.createDocument(nullNS, "staff", nullDocType);
  imported = newDoc.importNode(employeeElem, true);
  attrNode = ((Element) /*Node */imported).getAttributeNodeNS(nullNS, "defaultAttr");
  assertNull(attrNode, "defaultAttrNotImported");
  attrValue = ((Element) /*Node */imported).getAttributeNS("http://www.w3.org/2000/xmlns/", "emp");
  assertEquals("http://www.nist.gov", attrValue, "explicitAttrImported");
 }
}