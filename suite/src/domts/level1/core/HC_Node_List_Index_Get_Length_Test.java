package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getLength()" method returns the number of nodes
* in the list.
* 
* Create a list of all the children elements of the third
* employee and invoke the "getLength()" method. 
* It should contain the value 13.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-203510337">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-203510337</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=246">http://www.w3.org/Bugs/Public/show_bug.cgi?id=246</a>
*/
class HC_Node_List_Index_Get_Length_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodelistindexgetlength")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  NodeList employeeList;
  int length;
  doc = (Document) load("hc_staff", false);
  elementList = doc.getElementsByTagName("p");
  employeeNode = elementList.item(2);
  employeeList = employeeNode.getChildNodes();
  length = (int) employeeList.getLength();
  if (equals(6, length)) {
   assertEquals(6, length, "length_wo_space");
  } else {
   assertEquals(13, length, "length_w_space");
  }
 }
}