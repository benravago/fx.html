package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getNamedItem(name)" method returns a node of any 
* type specified by name. 
* 
* Retrieve the second employee and create a NamedNodeMap 
* listing of the attributes of the last child.  Once the
* list is created an invocation of the "getNamedItem(name)"
* method is done with name="street".  This should result
* in the method returning an Attr node.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1074577549">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1074577549</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-637646024">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-637646024</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1112119403">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1112119403</a>
*/
class NamedNodeMap_Return_Attr_Node_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/namednodemapreturnattrnode")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node testEmployee;
  NamedNodeMap attributes;
  Node streetAttr;
  String attrName;
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("address");
  testEmployee = elementList.item(1);
  attributes = testEmployee.getAttributes();
  streetAttr = attributes.getNamedItem("street");
  assertTrue(instanceOf(Attr.class, streetAttr), "typeAssert");
  attrName = streetAttr.getNodeName();
  assertEquals("street", attrName, "nodeName");
  attrName = ((Attr) /*Node */streetAttr).getName();
  assertEquals("street", attrName, "attrName");
 }
}