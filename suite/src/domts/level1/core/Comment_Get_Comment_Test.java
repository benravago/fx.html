package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* A comment is all the characters between the starting
* '<!--' and ending '-->' 
* Retrieve the nodes of the DOM document.  Search for a 
* comment node and the content is its value.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1334481328">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1334481328</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D080">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D080</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-111237558">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-111237558</a>
*/
class Comment_Get_Comment_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/commentgetcomment")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node child;
  String childName;
  String childValue;
  int commentCount = 0;
  int childType;
  doc = (Document) load("staff", false);
  elementList = doc.getChildNodes();
  for (int indexN10057 = 0; indexN10057 < elementList.getLength(); indexN10057++) {
   child = (Node) elementList.item(indexN10057);
   childType = (int) child.getNodeType();
   if (equals(8, childType)) {
    childName = child.getNodeName();
    assertEquals("#comment", childName, "nodeName");
    childValue = child.getNodeValue();
    assertEquals(" This is comment number 1.", childValue, "nodeValue");
    commentCount = commentCount + 1;
   }
  }
  assertEquals(1, commentCount, "commentCount");
 }
}