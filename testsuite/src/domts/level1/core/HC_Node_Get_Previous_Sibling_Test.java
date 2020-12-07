package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getPreviousSibling()" method returns the node
* immediately preceding this node. 
* 
* Retrieve the second child of the second employee and    
* invoke the "getPreviousSibling()" method.   It should
* return a node with a NodeName of "#text".
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-640FB3C8">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-640FB3C8</a>
*/
@Disabled("fx")
class HC_Node_Get_Previous_Sibling_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodegetprevioussibling")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node nameNode;
  Node psNode;
  String psName;
  doc = (Document) load("hc_staff", false);
  elementList = doc.getElementsByTagName("strong");
  nameNode = elementList.item(1);
  psNode = nameNode.getPreviousSibling();
  psName = psNode.getNodeName();
  assertEquals("#text", psName, "whitespace");
 }
}