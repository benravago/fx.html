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
* using the special value " " as the namespaceURI and "address" as the 
* localName.
* The method should return a NodeList of Elements that have
* "address" as the local name.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getElBTNNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getElBTNNS</a>
*/
class Get_Elements_By_TagName_NS_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/getElementsByTagNameNS04")
 void run() throws Throwable {
  Document doc;
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
  elementList = doc.getElementsByTagNameNS("*", "address");
  for (int indexN10059 = 0; indexN10059 < elementList.getLength(); indexN10059++) {
   child = (Node) elementList.item(indexN10059);
   childName = child.getNodeName();
   result.add(childName);
  }
  assertEquals(expectedResult, result, "nodeNames");
 }
}