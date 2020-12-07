package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Retrieve the second "p" element and create a NamedNodeMap 
* object from the attributes of the last child by
* invoking the "getAttributes()" method.  Once the
* list is created an invocation of the "setNamedItem(arg)"
* method is done with arg=newAttr, where newAttr is a
* new Attr Node previously created.  The "setNamedItem(arg)"
* method should add then new node to the NamedNodeItem 
* object by using its "nodeName" attribute("lang').
* This node is then retrieved using the "getNamedItem(name)"
* method.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1025163788">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1025163788</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-349467F9">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-349467F9</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=236">http://www.w3.org/Bugs/Public/show_bug.cgi?id=236</a>
* @see <a href="http://lists.w3.org/Archives/Public/www-dom-ts/2003Jun/0011.html">http://lists.w3.org/Archives/Public/www-dom-ts/2003Jun/0011.html</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=243">http://www.w3.org/Bugs/Public/show_bug.cgi?id=243</a>
*/
class HC_NamedNodeMap_Set_Named_Item_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_namednodemapsetnameditem")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Attr newAttribute;
  Node testAddress;
  NamedNodeMap attributes;
  Attr districtNode;
  String attrName;
  Node setNode;
  doc = (Document) load("hc_staff", true);
  elementList = doc.getElementsByTagName("acronym");
  testAddress = elementList.item(1);
  newAttribute = doc.createAttribute("lang");
  attributes = testAddress.getAttributes();
  setNode = attributes.setNamedItem(newAttribute);
  districtNode = (Attr) attributes.getNamedItem("lang");
  attrName = districtNode.getNodeName();
  assertTrue(equalsAutoCase("attribute", "lang", attrName), "nodeName");
 }
}