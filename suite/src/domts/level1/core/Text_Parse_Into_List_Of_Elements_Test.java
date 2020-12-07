package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Retrieve the textual data from the last child of the 
* second employee.   That node is composed of two   
* EntityReference nodes and two Text nodes.   After
* the content node is parsed, the "address" Element
* should contain four children with each one of the
* EntityReferences containing one child.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1451460987">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1451460987</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-11C98490">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-11C98490</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-745549614">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-745549614</a>
*/
@Disabled("fx")
class Text_Parse_Into_List_Of_Elements_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/textparseintolistofelements")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node addressNode;
  NodeList childList;
  Node child;
  int length;
  String value;
  Node grandChild;
  List result = new ArrayList();
  List expectedNormal = new ArrayList();
  expectedNormal.add("1900 Dallas Road");
  expectedNormal.add(" Dallas, ");
  expectedNormal.add("Texas");
  expectedNormal.add("\n 98554");
  List expectedExpanded = new ArrayList();
  expectedExpanded.add("1900 Dallas Road Dallas, Texas\n 98554");
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("address");
  addressNode = elementList.item(1);
  childList = addressNode.getChildNodes();
  length = (int) childList.getLength();
  for (int indexN1007F = 0; indexN1007F < childList.getLength(); indexN1007F++) {
   child = (Node) childList.item(indexN1007F);
   value = child.getNodeValue();
   if ((value == null)) {
    grandChild = child.getFirstChild();
    assertNotNull(grandChild, "grandChildNotNull");
    value = grandChild.getNodeValue();
    result.add(value);
   } else {
    result.add(value);
   }
  }
  if (equals(4, length)) {
   assertEquals(expectedNormal, result, "assertEqNormal");
  } else {
   assertEquals(expectedExpanded, result, "assertEqCoalescing");
  }
 }
}