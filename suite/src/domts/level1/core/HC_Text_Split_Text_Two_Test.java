package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* After the "splitText(offset)" method breaks the Text node
* into two Text nodes, the original node contains all the
* content up to the offset point.
* 
* Retrieve the textual data from the second child of the 
* third employee and invoke the "splitText(offset)" method.
* The original Text node should contain all the content
* up to the offset point.   The "getNodeValue()" method
* is called to check that the original node now contains
* the first five characters.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-38853C1D">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-38853C1D</a>
*/
class HC_Text_Split_Text_Two_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_textsplittexttwo")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node nameNode;
  Text textNode;
  Text splitNode;
  String value;
  doc = (Document) load("hc_staff", true);
  elementList = doc.getElementsByTagName("strong");
  nameNode = elementList.item(2);
  textNode = (Text) nameNode.getFirstChild();
  splitNode = textNode.splitText(5);
  value = textNode.getNodeValue();
  assertEquals("Roger", value, "textSplitTextTwoAssert");
 }
}