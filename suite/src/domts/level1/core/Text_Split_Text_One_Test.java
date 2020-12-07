package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "splitText(offset)" method breaks the Text node into
* two Text nodes at the specified offset keeping each node
* as siblings in the tree.
* 
* Retrieve the textual data from the second child of the 
* third employee and invoke the "splitText(offset)" method.
* The method splits the Text node into two new sibling
* Text nodes keeping both of them in the tree.   This test
* checks the "nextSibling()" method of the original node
* to ensure that the two nodes are indeed siblings.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-38853C1D">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-38853C1D</a>
*/
class Text_Split_Text_One_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/textsplittextone")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node nameNode;
  Text textNode;
  Text splitNode;
  Node secondPart;
  String value;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("name");
  nameNode = elementList.item(2);
  textNode = (Text) nameNode.getFirstChild();
  splitNode = textNode.splitText(7);
  secondPart = textNode.getNextSibling();
  value = secondPart.getNodeValue();
  assertEquals("Jones", value, "textSplitTextOneAssert");
 }
}