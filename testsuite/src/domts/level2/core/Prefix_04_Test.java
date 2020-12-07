package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getPrefix()" method for a node
* returns the namespace prefix of this node, or null if it is unspecified.
* 
* Retrieve the first employee node and invoke the getPrefix() method."   
* The method should return "null". 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix</a>
*/
class Prefix_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/prefix04")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node testEmployee;
  String prefix;
  doc = (Document) load("staffNS", false);
  elementList = doc.getElementsByTagName("employee");
  testEmployee = elementList.item(0);
  prefix = testEmployee.getPrefix();
  assertNull(prefix, "throw_Null");
 }
}