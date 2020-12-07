package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Retrieve the second salary and
* the "cloneNode(deep)" method with deep=true.   The
* duplicate node returned by the method should copy
* any text data contained in this node.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-3A0ED0A4">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-3A0ED0A4</a>
*/
class Node_Clone_True_Copy_Text_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodeclonetruecopytext")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  NodeList childList;
  Node childNode;
  Node clonedNode;
  Node lastChildNode;
  String childValue;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("salary");
  childNode = elementList.item(1);
  clonedNode = childNode.cloneNode(true);
  lastChildNode = clonedNode.getLastChild();
  childValue = lastChildNode.getNodeValue();
  assertEquals("35,000", childValue, "nodeCloneTrueCopyTextAssert1");
 }
}