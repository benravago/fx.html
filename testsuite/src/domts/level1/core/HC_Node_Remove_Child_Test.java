package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "removeChild(oldChild)" method removes the child node
* indicated by "oldChild" from the list of children and
* returns it. 
* 
* Remove the first employee by invoking the
* "removeChild(oldChild)" method an checking the
* node returned by the "getParentNode()" method.   It
* should be set to null.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1734834066">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1734834066</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=249">http://www.w3.org/Bugs/Public/show_bug.cgi?id=249</a>
*/
class HC_Node_Remove_Child_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_noderemovechild")
 void run() throws Throwable {
  Document doc;
  Element rootNode;
  NodeList childList;
  Node childToRemove;
  Node removedChild;
  Node parentNode;
  doc = (Document) load("hc_staff", true);
  rootNode = doc.getDocumentElement();
  childList = rootNode.getChildNodes();
  childToRemove = childList.item(1);
  removedChild = rootNode.removeChild(childToRemove);
  parentNode = removedChild.getParentNode();
  assertNull(parentNode, "parentNodeNull");
 }
}