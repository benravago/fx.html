package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "hasChildNodes()" method returns false if the node
* does not have any children.
* 
* Retrieve the text of the first "em" element and invoke the "hasChildNodes()" method.   It
* should return false.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1451460987">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1451460987</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-810594187">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-810594187</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=246">http://www.w3.org/Bugs/Public/show_bug.cgi?id=246</a>
*/
class HC_Node_Has_Child_Nodes_False_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodehaschildnodesfalse")
 void run() throws Throwable {
  Document doc;
  NodeList emList;
  Node emNode;
  CharacterData emText;
  boolean hasChild;
  doc = (Document) load("hc_staff", false);
  emList = doc.getElementsByTagName("em");
  emNode = emList.item(0);
  emText = (CharacterData) emNode.getFirstChild();
  hasChild = emText.hasChildNodes();
  assertFalse(hasChild, "hasChild");
 }
}