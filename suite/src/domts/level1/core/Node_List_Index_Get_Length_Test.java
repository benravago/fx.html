package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getLength()" method returns the number of nodes
* in the list should be 6 (no whitespace) or 13.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-203510337">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-203510337</a>
*/
class Node_List_Index_Get_Length_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodelistindexgetlength")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  NodeList employeeList;
  int length;
  int expectedCount = 0;
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("employee");
  employeeNode = elementList.item(2);
  employeeList = employeeNode.getChildNodes();
  length = (int) employeeList.getLength();
  assertTrue((equals(6, length) | equals(13, length)), "lengthIs6or13");
 }
}