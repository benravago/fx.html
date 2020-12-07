package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getNamespaceURI()" method for a Node
* returns the namespace URI of this node, or null if unspecified.
* 
* Retrieve the second employee node and invoke the "getNamespaceURI()"   
* method.   The method should return "null". 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSname">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSname</a>
*/
class Namespace_URI_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/namespaceURI04")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node testEmployee;
  String employeeNamespace;
  doc = (Document) load("staffNS", false);
  elementList = doc.getElementsByTagName("employee");
  testEmployee = elementList.item(1);
  employeeNamespace = testEmployee.getNamespaceURI();
  assertNull(employeeNamespace, "throw_Null");
 }
}