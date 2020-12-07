package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The string returned by the "getNodeName()" method for a 
* Text Node is "#text".
* 
* Retrieve the Text Node from the last child of the
* first employee and check the string returned 
* by the "getNodeName()" method.   It should be equal to 
* "#text". 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095</a>
*/
class Node_Text_Node_Name_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodetextnodename")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testAddr;
  Node textNode;
  String textName;
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("address");
  testAddr = (Element) elementList.item(0);
  textNode = testAddr.getFirstChild();
  textName = textNode.getNodeName();
  assertEquals("#text", textName, "nodeTextNodeNameAssert1");
 }
}