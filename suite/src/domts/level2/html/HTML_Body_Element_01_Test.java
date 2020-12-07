package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The aLink attribute specifies the color of active links. 
* Retrieve the aLink attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-59424581">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-59424581</a>
*/
class HTML_Body_Element_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "body", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLBodyElement01")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String valink;
  Document doc;
  doc = (Document) load("body", false);
  nodeList = doc.getElementsByTagName("body");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  valink = ((HTMLBodyElement) /*Node */testNode).getALink();
  assertEquals("#0000ff", valink, "aLinkLink");
 }
}