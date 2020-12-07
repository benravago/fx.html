package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getParentNode()" method invoked on a node that has
* just been created and not yet added to the tree is null. 
* Create a new "employee" Element node using the             
* "createElement(name)" method from the Document interface.
* Since this new node has not yet been added to the tree,
* the "getParentNode()" method will return null.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1060184317">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1060184317</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=247">http://www.w3.org/Bugs/Public/show_bug.cgi?id=247</a>
*/
class HC_Node_Parent_Node_Null_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodeparentnodenull")
 void run() throws Throwable {
  Document doc;
  Element createdNode;
  Node parentNode;
  doc = (Document) load("hc_staff", false);
  createdNode = doc.createElement("br");
  parentNode = createdNode.getParentNode();
  assertNull(parentNode, "parentNode");
 }
}