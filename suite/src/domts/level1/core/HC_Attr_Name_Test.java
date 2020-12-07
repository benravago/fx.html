package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Retrieve the attribute named class from the last 
* child of of the second "p" element and examine its 
* NodeName.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1112119403">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1112119403</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=236">http://www.w3.org/Bugs/Public/show_bug.cgi?id=236</a>
* @see <a href="http://lists.w3.org/Archives/Public/www-dom-ts/2003Jun/0011.html">http://lists.w3.org/Archives/Public/www-dom-ts/2003Jun/0011.html</a>
*/
class HC_Attr_Name_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_attrname")
 void run() throws Throwable {
  Document doc;
  NodeList addressList;
  Node testNode;
  NamedNodeMap attributes;
  Attr streetAttr;
  String strong1;
  String strong2;
  doc = (Document) load("hc_staff", false);
  addressList = doc.getElementsByTagName("acronym");
  testNode = addressList.item(1);
  attributes = testNode.getAttributes();
  streetAttr = (Attr) attributes.getNamedItem("class");
  strong1 = streetAttr.getNodeName();
  strong2 = streetAttr.getName();
  assertTrue(equalsAutoCase("attribute", "class", strong1), "nodeName");
  assertTrue(equalsAutoCase("attribute", "class", strong2), "name");
 }
}