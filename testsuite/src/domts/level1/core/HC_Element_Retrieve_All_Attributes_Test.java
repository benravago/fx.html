package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Create a list of all the attributes of the last child
* of the first "p" element by using the "getAttributes()"
* method.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096</a>
* @see <a href="http://lists.w3.org/Archives/Public/www-dom-ts/2002Mar/0002.html">http://lists.w3.org/Archives/Public/www-dom-ts/2002Mar/0002.html</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=184">http://www.w3.org/Bugs/Public/show_bug.cgi?id=184</a>
*/
class HC_Element_Retrieve_All_Attributes_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_elementretrieveallattributes")
 void run() throws Throwable {
  Document doc;
  NodeList addressList;
  Node testAddress;
  NamedNodeMap attributes;
  Attr attribute;
  String attributeName;
  Collection actual = new ArrayList();
  Collection htmlExpected = new ArrayList();
  htmlExpected.add("title");
  Collection expected = new ArrayList();
  expected.add("title");
  expected.add("dir");
  doc = (Document) load("hc_staff", false);
  addressList = doc.getElementsByTagName("acronym");
  testAddress = addressList.item(0);
  attributes = testAddress.getAttributes();
  for (int indexN1006B = 0; indexN1006B < attributes.getLength(); indexN1006B++) {
   attribute = (Attr) attributes.item(indexN1006B);
   attributeName = attribute.getNodeName();
   actual.add(attributeName);
  }
  if (("text/html".equals(getContentType()))) {
   assertTrue(equalsIgnoreCase(htmlExpected, actual), "htmlAttributeNames");
  } else {
   assertTrue(equalsIgnoreCase(expected, actual), "attributeNames");
  }
 }
}