package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getNodeType()" method for a CDATASection Node
* returns the constant value 4.
* 
* Retrieve the CDATASection node contained inside the
* second child of the second employee and invoke the 
* "getNodeType()" method.   The method should return 4. 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-111237558">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-111237558</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-667469212">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-667469212</a>
*/
class Node_CDATASection_Node_Type_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setCoalescing(false);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodecdatasectionnodetype")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testName;
  Node cdataNode;
  int nodeType;
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("name");
  testName = (Element) elementList.item(1);
  cdataNode = testName.getLastChild();
  nodeType = (int) cdataNode.getNodeType();
  if (equals(3, nodeType)) {
   cdataNode = doc.createCDATASection("");
   nodeType = (int) cdataNode.getNodeType();
  }
  assertEquals(4, nodeType, "nodeTypeCDATA");
 }
}