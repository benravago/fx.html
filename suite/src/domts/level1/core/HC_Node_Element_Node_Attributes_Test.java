package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Retrieve the third "acronym" element and evaluate Node.attributes.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=236">http://www.w3.org/Bugs/Public/show_bug.cgi?id=236</a>
* @see <a href="http://lists.w3.org/Archives/Public/www-dom-ts/2003Jun/0011.html">http://lists.w3.org/Archives/Public/www-dom-ts/2003Jun/0011.html</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=184">http://www.w3.org/Bugs/Public/show_bug.cgi?id=184</a>
*/
@Disabled("1")
class HC_Node_Element_Node_Attributes_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodeelementnodeattributes")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testAddr;
  NamedNodeMap addrAttr;
  Node attrNode;
  String attrName;
  Collection attrList = new ArrayList();
  Collection htmlExpected = new ArrayList();
  htmlExpected.add("title");
  htmlExpected.add("class");
  Collection expected = new ArrayList();
  expected.add("title");
  expected.add("class");
  expected.add("dir");
  doc = (Document) load("hc_staff", false);
  elementList = doc.getElementsByTagName("acronym");
  testAddr = (Element) elementList.item(2);
  addrAttr = testAddr.getAttributes();
  for (int indexN10070 = 0; indexN10070 < addrAttr.getLength(); indexN10070++) {
   attrNode = (Node) addrAttr.item(indexN10070);
   attrName = attrNode.getNodeName();
   attrList.add(attrName);
  }
  if (("text/html".equals(getContentType()))) {
   assertTrue(equalsIgnoreCase(htmlExpected, attrList), "attrNames_html");
  } else {
   assertEquals(expected, attrList, "attrNames");
  }
 }
}