package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getElementsByTagNameNS(namespaceURI,localName)" method for a 
* Document should return a new NodeList of all Elements with a given
* localName and namespaceURI in the order they were encountered in a preorder
* traversal of the document tree.
* 
* Invoke method getElementsByTagNameNS(namespaceURI,localName) on this document
* with namespaceURI being " " and localName is "employee".
* Method should return a new NodeList containing five Elements. 
* Retrieve the FOURTH element whose name should be "emp:employee".
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getElBTNNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getElBTNNS</a>
*/
class Get_Elements_By_TagName_NS_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/getElementsByTagNameNS02")
 void run() throws Throwable {
  Document doc;
  NodeList newList;
  Element newElement;
  String prefix;
  String lname;
  doc = (Document) load("staffNS", false);
  newList = doc.getElementsByTagNameNS("*", "employee");
  assertTrue(equalsSize(5, newList), "employeeCount");
  newElement = (Element) newList.item(3);
  prefix = newElement.getPrefix();
  assertEquals("emp", prefix, "prefix");
  lname = newElement.getLocalName();
  assertEquals("employee", lname, "lname");
 }
}