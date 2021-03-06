package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getNamedItem(name)" method returns null of the 
* specified name did not identify any node in the map. 
* 
* Retrieve the second employee and create a NamedNodeMap 
* listing of the attributes of the last child.  Once the
* list is created an invocation of the "getNamedItem(name)"
* method is done with name="district".  This name does not 
* match any names in the list therefore the method should
* return null.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1074577549">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1074577549</a>
*/
class NamedNodeMap_Return_Null_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/namednodemapreturnnull")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node testEmployee;
  NamedNodeMap attributes;
  Attr districtNode;
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("address");
  testEmployee = elementList.item(1);
  attributes = testEmployee.getAttributes();
  districtNode = (Attr) attributes.getNamedItem("district");
  assertNull(districtNode, "namednodemapReturnNullAssert");
 }
}