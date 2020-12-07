package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The string returned by the "getNodeValue()" method for a 
* Text Node is the content of the Text node.
* 
* Retrieve the Text node from the last child of the first 
* employee and check the string returned by the 
* "getNodeValue()" method.   It should be equal to 
* "1230 North Ave. Dallas, Texas 98551". 
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D080">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D080</a>
*/
class HC_Node_Text_Node_Value_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodetextnodevalue")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testAddr;
  Node textNode;
  String textValue;
  doc = (Document) load("hc_staff", false);
  elementList = doc.getElementsByTagName("acronym");
  testAddr = (Element) elementList.item(0);
  textNode = testAddr.getFirstChild();
  textValue = textNode.getNodeValue();
  assertEquals("1230 North Ave. Dallas, Texas 98551", textValue, "textNodeValue");
 }
}