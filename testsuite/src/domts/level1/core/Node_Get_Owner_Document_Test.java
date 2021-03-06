package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getOwnerDocument()" method returns the Document
* object associated with this node.
* 
* Retrieve the second employee and examine Document 
* returned by the "getOwnerDocument()" method.   Invoke
* the "getDocumentElement()" on the Document which will
* return an Element that is equal to "staff".
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#node-ownerDoc">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#node-ownerDoc</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=251">http://www.w3.org/Bugs/Public/show_bug.cgi?id=251</a>
*/
class Node_Get_Owner_Document_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodegetownerdocument")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node docNode;
  Document ownerDocument;
  Element docElement;
  String elementName;
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("employee");
  docNode = elementList.item(1);
  ownerDocument = docNode.getOwnerDocument();
  docElement = ownerDocument.getDocumentElement();
  elementName = docElement.getNodeName();
  if (("image/svg+xml".equals(getContentType()))) {
   assertEquals("svg", elementName, "svgTagName");
  } else {
   assertEquals("staff", elementName, "nodeGetOwnerDocumentAssert1");
  }
 }
}