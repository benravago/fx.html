package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getAttributes()" method invoked on a Comment 
* Node returns null.
* Find any comment that is an immediate child of the root
* and assert that Node.attributes is null.  Then create
* a new comment node (in case they had been omitted) and
* make the assertion.    
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1728279322">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1728279322</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=248">http://www.w3.org/Bugs/Public/show_bug.cgi?id=248</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=263">http://www.w3.org/Bugs/Public/show_bug.cgi?id=263</a>
*/
class HC_Node_Comment_Node_Attributes_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodecommentnodeattributes")
 void run() throws Throwable {
  Document doc;
  Node commentNode;
  NodeList nodeList;
  NamedNodeMap attrList;
  int nodeType;
  doc = (Document) load("hc_staff", false);
  nodeList = doc.getChildNodes();
  for (int indexN10043 = 0; indexN10043 < nodeList.getLength(); indexN10043++) {
   commentNode = (Node) nodeList.item(indexN10043);
   nodeType = (int) commentNode.getNodeType();
   if (equals(8, nodeType)) {
    attrList = commentNode.getAttributes();
    assertNull(attrList, "existingCommentAttributesNull");
   }
  }
  commentNode = doc.createComment("This is a comment");
  attrList = commentNode.getAttributes();
  assertNull(attrList, "createdCommentAttributesNull");
 }
}