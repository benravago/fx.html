package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "setNamedItem(arg)" method adds a node using its 
* nodeName attribute. 
* 
* Retrieve the second employee and create a NamedNodeMap 
* object from the attributes of the last child by
* invoking the "getAttributes()" method.  Once the
* list is created an invocation of the "setNamedItem(arg)"
* method is done with arg=newAttr, where newAttr is a
* new Attr Node previously created.  The "setNamedItem(arg)"
* method should add then new node to the NamedNodeItem 
* object by using its "nodeName" attribute("district').
* This node is then retrieved using the "getNamedItem(name)"
* method.  This test uses the "createAttribute(name)"
* method from the document interface.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1025163788">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1025163788</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-349467F9">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-349467F9</a>
*/
class NamedNodeMap_Set_Named_Item_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/namednodemapsetnameditem")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Attr newAttribute;
  Node testAddress;
  NamedNodeMap attributes;
  Attr districtNode;
  String attrName;
  Node setNode;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("address");
  testAddress = elementList.item(1);
  newAttribute = doc.createAttribute("district");
  attributes = testAddress.getAttributes();
  setNode = attributes.setNamedItem(newAttribute);
  districtNode = (Attr) attributes.getNamedItem("district");
  attrName = districtNode.getNodeName();
  assertEquals("district", attrName, "namednodemapSetNamedItemAssert");
 }
}