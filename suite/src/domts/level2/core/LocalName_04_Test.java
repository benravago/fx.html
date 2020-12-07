package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getLocalName()" method for a Node
* returns the local part of the qualified name of this node,
* and for nodes of any type other than ELEMENT_NODE and ATTRIBUTE_NODE
* and nodes created with a DOM Level 1 method, this is null.
* 
* Retrieve the first employee node and invoke the "getLocalName()"   
* method.   The method should return "employee". 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSLocalN">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSLocalN</a>
*/
class LocalName_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/localName04")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node testEmployee;
  String employeeLocalName;
  doc = (Document) load("staffNS", false);
  elementList = doc.getElementsByTagName("employee");
  testEmployee = elementList.item(0);
  employeeLocalName = testEmployee.getLocalName();
  assertEquals("employee", employeeLocalName, "lname");
 }
}