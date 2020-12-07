package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getNextSibling()" method returns the node immediately
* following this node. 
* 
* Retrieve the first child of the second employee and
* invoke the "getNextSibling()" method.   It should return
* a node with the NodeName of "#text".
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-6AC54C2F">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-6AC54C2F</a>
*/
@Disabled("fx")
class HC_Node_Get_Next_Sibling_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodegetnextsibling")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node emNode;
  Node nsNode;
  String nsName;
  doc = (Document) load("hc_staff", false);
  elementList = doc.getElementsByTagName("em");
  emNode = elementList.item(1);
  nsNode = emNode.getNextSibling();
  nsName = nsNode.getNodeName();
  assertEquals("#text", nsName, "whitespace");
 }
}