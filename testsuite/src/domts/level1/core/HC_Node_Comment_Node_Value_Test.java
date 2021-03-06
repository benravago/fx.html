package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The string returned by the "getNodeValue()" method for a 
* Comment Node is the content of the comment.
* 
* Retrieve the comment in the XML file and   
* check the string returned by the "getNodeValue()" method. 
* It should be equal to "This is comment number 1".
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D080">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D080</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1728279322">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1728279322</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=248">http://www.w3.org/Bugs/Public/show_bug.cgi?id=248</a>
*/
class HC_Node_Comment_Node_Value_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodecommentnodevalue")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node commentNode;
  String commentName;
  String commentValue;
  doc = (Document) load("hc_staff", false);
  elementList = doc.getChildNodes();
  for (int indexN10040 = 0; indexN10040 < elementList.getLength(); indexN10040++) {
   commentNode = (Node) elementList.item(indexN10040);
   commentName = commentNode.getNodeName();
   if (equals("#comment", commentName)) {
    commentValue = commentNode.getNodeValue();
    assertEquals(" This is comment number 1.", commentValue, "value");
   }
  }
  commentNode = doc.createComment(" This is a comment");
  commentValue = commentNode.getNodeValue();
  assertEquals(" This is a comment", commentValue, "createdCommentNodeValue");
 }
}