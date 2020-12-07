package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getElementsByTagNameNS(namespaceURI,localName)" method for a 
* Element should return a new NodeList of all descendant Elements with a given
* localName and namespaceURI in the order they were encountered in a preorder
* traversal of the document tree.
* 
* Invoke method getElementsByTagNameNS(namespaceURI,localName) on the document
* element with namespaceURI being "*" and localName is "employee".
* Method should return a new NodeList containing five Elements. 
* Retrieve the FOURTH element whose name should be "emp:employee".
* Derived from getElementsByTagNameNS02 and reflects its interpretation
* that namespace="*" matches namespace unqualified tagnames.
* @author Curt Arnold
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-1938918D">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-1938918D</a>
*/
class Get_Elements_By_TagName_NS_09_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/getElementsByTagNameNS09")
 void run() throws Throwable {
  Document doc;
  NodeList newList;
  Element newElement;
  String prefix;
  String lname;
  Element docElem;
  doc = (Document) load("staffNS", false);
  docElem = doc.getDocumentElement();
  newList = docElem.getElementsByTagNameNS("*", "employee");
  assertTrue(equalsSize(5, newList), "employeeCount");
  newElement = (Element) newList.item(3);
  prefix = newElement.getPrefix();
  assertEquals("emp", prefix, "prefix");
  lname = newElement.getLocalName();
  assertEquals("employee", lname, "lname");
 }
}