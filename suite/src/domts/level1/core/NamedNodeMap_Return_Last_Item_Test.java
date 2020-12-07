package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "item(index)" method returns the indexth item in 
* the map(test for last item). 
* 
* Retrieve the second employee and create a NamedNodeMap 
* listing of the attributes of the last child. Since the
* DOM does not specify an order of these nodes the contents
* of the LAST node can contain either "domestic" or "street".
* The test should return "true" if the LAST node is either
* of these values.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-349467F9">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-349467F9</a>
*/
class NamedNodeMap_Return_Last_Item_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/namednodemapreturnlastitem")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node testEmployee;
  NamedNodeMap attributes;
  Node child;
  String name;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("address");
  testEmployee = elementList.item(1);
  attributes = testEmployee.getAttributes();
  child = attributes.item(1);
  name = child.getNodeName();
  assertTrue((equals("domestic", name) | equals("street", name)), "namednodemapReturnLastItemAssert");
 }
}