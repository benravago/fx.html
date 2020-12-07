package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getElementsByTagNameNS(namespaceURI,localName)" method returns a NodeList
* of all descendant Elements with a given local name and namespace URI in the
* order in which they are encountered in a preorder traversal of this Element tree.
* 
* Create a NodeList of all the descendant elements
* using the special value "*" as the namespaceURI and "address" as the 
* localName.
* The method should return a NodeList of Elements that have
* "address" as the local name.  
* This test is derived from getElementsByTagNameNS04
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-1938918D">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-1938918D</a>
*/
class Get_Elements_By_TagName_NS_11_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/getElementsByTagNameNS11")
 void run() throws Throwable {
  Document doc;
  Element docElem;
  NodeList elementList;
  Node child;
  String childName;
  List result = new ArrayList();
  List expectedResult = new ArrayList();
  expectedResult.add("address");
  expectedResult.add("address");
  expectedResult.add("address");
  expectedResult.add("emp:address");
  expectedResult.add("address");
  doc = (Document) load("staffNS", false);
  docElem = doc.getDocumentElement();
  elementList = docElem.getElementsByTagNameNS("*", "address");
  for (int indexN1005E = 0; indexN1005E < elementList.getLength(); indexN1005E++) {
   child = (Node) elementList.item(indexN1005E);
   childName = child.getNodeName();
   result.add(childName);
  }
  assertEquals(expectedResult, result, "nodeNames");
 }
}