package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getNamedItem(name)" method retrieves a node 
* specified by name. 
* 
* Retrieve the second employee and create a NamedNodeMap 
* listing of the attributes of the last child.  Once the
* list is created an invocation of the "getNamedItem(name)"
* method is done with name="domestic".  This should result
* in the domestic Attr node being returned.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1074577549">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1074577549</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-349467F9">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-349467F9</a>
*/
class NamedNodeMap_Get_Named_Item_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/namednodemapgetnameditem")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node testEmployee;
  NamedNodeMap attributes;
  Attr domesticAttr;
  String attrName;
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("address");
  testEmployee = elementList.item(1);
  attributes = testEmployee.getAttributes();
  domesticAttr = (Attr) attributes.getNamedItem("domestic");
  attrName = domesticAttr.getNodeName();
  assertEquals("domestic", attrName, "namednodemapGetNamedItemAssert");
 }
}