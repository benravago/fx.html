package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getLength()" method returns the number of nodes
* in the list.(Test for EMPTY list)
* 
* Create a list of all the children of the Text node 
* inside the first child of the third employee and
* invoke the "getLength()" method.   It should contain
* the value 0.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-203510337">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-203510337</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=246">http://www.w3.org/Bugs/Public/show_bug.cgi?id=246</a>
*/
class HC_Node_List_Index_Get_Length_Of_Empty_List_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodelistindexgetlengthofemptylist")
 void run() throws Throwable {
  Document doc;
  NodeList emList;
  Node emNode;
  Node textNode;
  NodeList textList;
  int length;
  doc = (Document) load("hc_staff", false);
  emList = doc.getElementsByTagName("em");
  emNode = emList.item(2);
  textNode = emNode.getFirstChild();
  textList = textNode.getChildNodes();
  length = (int) textList.getLength();
  assertEquals(0, length, "length");
 }
}