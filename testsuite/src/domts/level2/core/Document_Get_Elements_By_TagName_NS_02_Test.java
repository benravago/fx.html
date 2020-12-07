package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method getElementsByTagNameNS returns a NodeList of all the Elements with 
* a given local name and namespace URI in the order in which they are encountered 
* in a preorder traversal of the Document tree.
* 
* 
* Create a new element having a local name="employeeId" belonging to the namespace "test"
* and append it to this document.  Invoke the getElementsByTagNameNS method on a this
* Document object with the values of namespaceURI=* and localName="elementId".  This 
* should return a nodeList of 6 item.  Check the length of the nodeList returned.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core">http://www.w3.org/TR/DOM-Level-2-Core/core</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getElBTNNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getElBTNNS</a>
*/
class Document_Get_Elements_By_TagName_NS_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/documentgetelementsbytagnameNS02")
 void run() throws Throwable {
  Document doc;
  Element docElem;
  Element element;
  NodeList childList;
  Node appendedChild;
  doc = (Document) load("staffNS", true);
  docElem = doc.getDocumentElement();
  element = doc.createElementNS("test", "employeeId");
  appendedChild = docElem.appendChild(element);
  childList = doc.getElementsByTagNameNS("*", "employeeId");
  assertTrue(equalsSize(6, childList), "documentgetelementsbytagnameNS02");
 }
}