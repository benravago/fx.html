package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getElementsByTagName(name)" method may use the
* special value "*" to match all tags in the element
* tree.
* Create a NodeList of all the descendant elements
* of the last employee by using the special value "*".
* The method should return all the descendant children(6)
* in the order the children were encountered.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1938918D">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1938918D</a>
*/
@Disabled("fx")
class HC_Element_Get_Elements_By_TagName_Special_Value_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_elementgetelementsbytagnamespecialvalue")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element lastEmployee;
  NodeList lastempList;
  Node child;
  String childName;
  List result = new ArrayList();
  List expectedResult = new ArrayList();
  expectedResult.add("em");
  expectedResult.add("strong");
  expectedResult.add("code");
  expectedResult.add("sup");
  expectedResult.add("var");
  expectedResult.add("acronym");
  doc = (Document) load("hc_staff", false);
  elementList = doc.getElementsByTagName("p");
  lastEmployee = (Element) elementList.item(4);
  lastempList = lastEmployee.getElementsByTagName("*");
  for (int indexN10067 = 0; indexN10067 < lastempList.getLength(); indexN10067++) {
   child = (Node) lastempList.item(indexN10067);
   childName = child.getNodeName();
   result.add(childName);
  }
  assertTrue(equalsAutoCase("element", expectedResult, result), "tagNames");
 }
}