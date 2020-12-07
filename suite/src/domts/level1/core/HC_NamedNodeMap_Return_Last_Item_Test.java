package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "item(index)" method returns the indexth item in 
* the map(test for last item). 
* 
* Retrieve the second "acronym" and get the attribute name. Since the
* DOM does not specify an order of these nodes the contents
* of the LAST node can contain either "title" or "class".
* The test should return "true" if the LAST node is either
* of these values.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-349467F9">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-349467F9</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=236">http://www.w3.org/Bugs/Public/show_bug.cgi?id=236</a>
* @see <a href="http://lists.w3.org/Archives/Public/www-dom-ts/2003Jun/0011.html">http://lists.w3.org/Archives/Public/www-dom-ts/2003Jun/0011.html</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=184">http://www.w3.org/Bugs/Public/show_bug.cgi?id=184</a>
*/
@Disabled("1")
class HC_NamedNodeMap_Return_Last_Item_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_namednodemapreturnlastitem")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node testEmployee;
  NamedNodeMap attributes;
  Node child;
  String nodeName;
  Collection htmlExpected = new ArrayList();
  htmlExpected.add("title");
  htmlExpected.add("class");
  Collection expected = new ArrayList();
  expected.add("title");
  expected.add("class");
  expected.add("dir");
  Collection actual = new ArrayList();
  doc = (Document) load("hc_staff", true);
  elementList = doc.getElementsByTagName("acronym");
  testEmployee = elementList.item(1);
  attributes = testEmployee.getAttributes();
  for (int indexN10070 = 0; indexN10070 < attributes.getLength(); indexN10070++) {
   child = (Node) attributes.item(indexN10070);
   nodeName = child.getNodeName();
   actual.add(nodeName);
  }
  if (("text/html".equals(getContentType()))) {
   assertTrue(equalsIgnoreCase(htmlExpected, actual), "attrName_html");
  } else {
   assertEquals(expected, actual, "attrName");
  }
 }
}