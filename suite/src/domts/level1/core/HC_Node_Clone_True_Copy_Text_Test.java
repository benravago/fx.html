package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "cloneNode(deep)" method does not copy text unless it
* is deep cloned.(Test for deep=true)
* 
* Retrieve the eighth child of the second employee and
* the "cloneNode(deep)" method with deep=true.   The
* duplicate node returned by the method should copy
* any text data contained in this node.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-3A0ED0A4">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-3A0ED0A4</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=246">http://www.w3.org/Bugs/Public/show_bug.cgi?id=246</a>
*/
class HC_Node_Clone_True_Copy_Text_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodeclonetruecopytext")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node childNode;
  Node clonedNode;
  Node lastChildNode;
  String childValue;
  doc = (Document) load("hc_staff", true);
  elementList = doc.getElementsByTagName("sup");
  childNode = elementList.item(1);
  clonedNode = childNode.cloneNode(true);
  lastChildNode = clonedNode.getLastChild();
  childValue = lastChildNode.getNodeValue();
  assertEquals("35,000", childValue, "cloneContainsText");
 }
}