package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* If there is not any markup inside an Element or Attr node
* content, then the text is contained in a single object   
* implementing the Text interface that is the only child
* of the element.
* 
* Retrieve the textual data from the second child of the 
* third employee.   That Text node contains a block of 
* multiple text lines without markup, so they should be
* treated as a single Text node.   The "getNodeValue()"    
* method should contain the combination of the two lines.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1312295772">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1312295772</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D080">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D080</a>
*/
class Text_With_No_Markup_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/textwithnomarkup")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node nameNode;
  Node nodeV;
  String value;
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("name");
  nameNode = elementList.item(2);
  nodeV = nameNode.getFirstChild();
  value = nodeV.getNodeValue();
  assertEquals("Roger\n Jones", value, "textNodeValue");
 }
}