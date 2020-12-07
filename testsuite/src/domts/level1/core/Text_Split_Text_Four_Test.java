package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "splitText(offset)" method returns the new Text node.
* 
* Retrieve the textual data from the last child of the 
* first employee and invoke the "splitText(offset)" method.
* The method should return the new Text node.   The offset
* value used for this test is 30.   The "getNodeValue()"
* method is called to check that the new node now contains
* the characters at and after position 30.
* (Starting count at 0)
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-38853C1D">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-38853C1D</a>
*/
class Text_Split_Text_Four_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/textsplittextfour")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node addressNode;
  Text textNode;
  Text splitNode;
  String value;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("address");
  addressNode = elementList.item(0);
  textNode = (Text) addressNode.getFirstChild();
  splitNode = textNode.splitText(30);
  value = splitNode.getNodeValue();
  assertEquals("98551", value, "textSplitTextFourAssert");
 }
}