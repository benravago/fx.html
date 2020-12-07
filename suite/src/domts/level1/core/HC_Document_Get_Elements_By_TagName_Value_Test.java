package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getElementsByTagName(tagName)" method returns a 
* NodeList of all the Elements with a given tagName
* in a pre-order traversal of the tree.
* 
* Retrieve the entire DOM document and invoke its 
* "getElementsByTagName(tagName)" method with tagName
* equal to "strong".  The method should return a NodeList 
* that contains 5 elements.  The FOURTH item in the
* list is retrieved and output.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-A6C9094">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-A6C9094</a>
*/
class HC_Document_Get_Elements_By_TagName_Value_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_documentgetelementsbytagnamevalue")
 void run() throws Throwable {
  Document doc;
  NodeList nameList;
  Node nameNode;
  Node firstChild;
  String childValue;
  doc = (Document) load("hc_staff", false);
  nameList = doc.getElementsByTagName("strong");
  nameNode = nameList.item(3);
  firstChild = nameNode.getFirstChild();
  childValue = firstChild.getNodeValue();
  assertEquals("Jeny Oconnor", childValue, "documentGetElementsByTagNameValueAssert");
 }
}