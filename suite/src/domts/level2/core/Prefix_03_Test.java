package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getPrefix()" method for a node
* returns the namespace prefix of this node, or null if it is unspecified.
* 
* Retrieve the first emp:employee node and invoke the getPrefix() method."   
* The method should return "emp". 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix</a>
*/
class Prefix_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/prefix03")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node testEmployee;
  String prefix;
  doc = (Document) load("staffNS", false);
  elementList = doc.getElementsByTagName("emp:employee");
  testEmployee = elementList.item(0);
  assertNotNull(testEmployee, "empEmployeeNotNull");
  prefix = testEmployee.getPrefix();
  assertEquals("emp", prefix, "prefix");
 }
}