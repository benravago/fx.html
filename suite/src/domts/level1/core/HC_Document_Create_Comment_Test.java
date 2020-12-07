package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "createComment(data)" method creates a new Comment
* node given the specified string. 
* Retrieve the entire DOM document and invoke its 
* "createComment(data)" method.  It should create a new
* Comment node whose "data" is the specified string.
* The content, name and type are retrieved and output.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1334481328">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1334481328</a>
*/
class HC_Document_Create_Comment_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_documentcreatecomment")
 void run() throws Throwable {
  Document doc;
  Comment newCommentNode;
  String newCommentValue;
  String newCommentName;
  int newCommentType;
  doc = (Document) load("hc_staff", true);
  newCommentNode = doc.createComment("This is a new Comment node");
  newCommentValue = newCommentNode.getNodeValue();
  assertEquals("This is a new Comment node", newCommentValue, "value");
  newCommentName = newCommentNode.getNodeName();
  assertEquals("#comment", newCommentName, "strong");
  newCommentType = (int) newCommentNode.getNodeType();
  assertEquals(8, newCommentType, "type");
 }
}