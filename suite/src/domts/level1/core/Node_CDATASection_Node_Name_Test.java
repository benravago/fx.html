package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The string returned by the "getNodeName()" method for a 
* CDATASection Node is #cdata-section".
* 
* Retrieve the CDATASection node inside the second child
* of the second employee and check the string returned 
* by the "getNodeName()" method.   It should be equal to 
* "#cdata-section". 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-667469212">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-667469212</a>
*/
class Node_CDATASection_Node_Name_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodecdatasectionnodename")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element cdataName;
  Node cdataNode;
  int nodeType;
  String cdataNodeName;
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("name");
  cdataName = (Element) elementList.item(1);
  cdataNode = cdataName.getLastChild();
  nodeType = (int) cdataNode.getNodeType();
  if (!equals(4, nodeType)) {
   cdataNode = doc.createCDATASection("");
  }
  cdataNodeName = cdataNode.getNodeName();
  assertEquals("#cdata-section", cdataNodeName, "cdataNodeName");
 }
}