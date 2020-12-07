package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getPrefix()" method
* returns the namespace prefix of this node, or null if unspecified.
* For nodes of any type other than ELEMENT_NODE and ATTRIBUTE_NODE,
* this is always null.
* 
* Retrieve the first emp:employeeId node and get the first child of this node.
* Since the first child is Text node invoking the "getPrefix()"   
* method will cause "null" to be returned. 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix</a>
*/
class Prefix_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/prefix02")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node testEmployee;
  Node textNode;
  String prefix;
  doc = (Document) load("staffNS", false);
  elementList = doc.getElementsByTagName("emp:employeeId");
  testEmployee = elementList.item(0);
  assertNotNull(testEmployee, "empEmployeeNotNull");
  textNode = testEmployee.getFirstChild();
  prefix = textNode.getPrefix();
  assertNull(prefix, "textNodePrefix");
 }
}