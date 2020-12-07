package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Retrieve the second acronym element and invoke
* the cloneNode method.   The
* duplicate node returned by the method should copy the
* attributes associated with this node.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=236">http://www.w3.org/Bugs/Public/show_bug.cgi?id=236</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=184">http://www.w3.org/Bugs/Public/show_bug.cgi?id=184</a>
*/
@Disabled("1")
class HC_Node_Clone_Attributes_Copied_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodecloneattributescopied")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node addressNode;
  Node clonedNode;
  NamedNodeMap attributes;
  Node attributeNode;
  String attributeName;
  Collection result = new ArrayList();
  Collection htmlExpected = new ArrayList();
  htmlExpected.add("class");
  htmlExpected.add("title");
  Collection expected = new ArrayList();
  expected.add("class");
  expected.add("title");
  expected.add("dir");
  doc = (Document) load("hc_staff", true);
  elementList = doc.getElementsByTagName("acronym");
  addressNode = elementList.item(1);
  clonedNode = addressNode.cloneNode(false);
  attributes = clonedNode.getAttributes();
  for (int indexN10076 = 0; indexN10076 < attributes.getLength(); indexN10076++) {
   attributeNode = (Node) attributes.item(indexN10076);
   attributeName = attributeNode.getNodeName();
   result.add(attributeName);
  }
  if (("text/html".equals(getContentType()))) {
   assertTrue(equalsIgnoreCase(htmlExpected, result), "nodeNames_html");
  } else {
   assertEquals(expected, result, "nodeNames");
  }
 }
}