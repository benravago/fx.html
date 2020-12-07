package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getAttributes()" method invoked on a CDATASection
* Node returns null.
* Retrieve the CDATASection node contained inside the
* second child of the second employee and invoke the
* "getAttributes()" method on the CDATASection node.
* It should return null.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-667469212">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-667469212</a>
*/
class Node_CDATASection_Node_Attribute_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodecdatasectionnodeattribute")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element cdataName;
  Node cdataNode;
  NamedNodeMap attrList;
  int nodeType;
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("name");
  cdataName = (Element) elementList.item(1);
  cdataNode = cdataName.getLastChild();
  nodeType = (int) cdataNode.getNodeType();
  if (!equals(4, nodeType)) {
   cdataNode = doc.createCDATASection("");
  }
  attrList = cdataNode.getAttributes();
  assertNull(attrList, "cdataSection");
 }
}