package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The string returned by the "getNodeName()" method for a 
* Comment Node is "#comment".
* 
* Retrieve the Comment node in the XML file 
* and check the string returned by the "getNodeName()" 
* method.   It should be equal to "#comment".
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1728279322">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1728279322</a>
*/
class Node_Comment_Node_Name_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodecommentnodename")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node commentNode;
  int nodeType;
  String commentNodeName;
  doc = (Document) load("staff", false);
  elementList = doc.getChildNodes();
  for (int indexN10040 = 0; indexN10040 < elementList.getLength(); indexN10040++) {
   commentNode = (Node) elementList.item(indexN10040);
   nodeType = (int) commentNode.getNodeType();
   if (equals(8, nodeType)) {
    commentNodeName = commentNode.getNodeName();
    assertEquals("#comment", commentNodeName, "commentNodeName");
   }
  }
 }
}