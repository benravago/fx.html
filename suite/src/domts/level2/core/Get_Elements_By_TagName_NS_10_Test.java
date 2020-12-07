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
* Create a NodeList of all the descendant elements of the document element
* using the "http://www.nist.gov" as the namespaceURI and the special value "*" as the 
* localName.
* The method should return a NodeList of elements that have "http://www.nist.gov
* as a namespace URI.
* Derived from getElementsByTagNameNS03
* @author Curt Arnold
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-1938918D">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-1938918D</a>
*/
class Get_Elements_By_TagName_NS_10_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/getElementsByTagNameNS10")
 void run() throws Throwable {
  Document doc;
  Element docElem;
  NodeList elementList;
  Node child;
  String childName;
  List result = new ArrayList();
  List expectedResult = new ArrayList();
  expectedResult.add("employee");
  expectedResult.add("employeeId");
  expectedResult.add("name");
  expectedResult.add("position");
  expectedResult.add("salary");
  expectedResult.add("gender");
  expectedResult.add("address");
  expectedResult.add("emp:employee");
  expectedResult.add("emp:employeeId");
  expectedResult.add("emp:position");
  expectedResult.add("emp:salary");
  expectedResult.add("emp:gender");
  expectedResult.add("emp:address");
  expectedResult.add("address");
  doc = (Document) load("staffNS", false);
  docElem = doc.getDocumentElement();
  elementList = docElem.getElementsByTagNameNS("http://www.nist.gov", "*");
  for (int indexN1007E = 0; indexN1007E < elementList.getLength(); indexN1007E++) {
   child = (Node) elementList.item(indexN1007E);
   childName = child.getNodeName();
   result.add(childName);
  }
  assertEquals(expectedResult, result, "nodeNames");
 }
}