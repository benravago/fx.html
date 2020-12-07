package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The string returned by the "getNodeName()" method for an 
* Element Node is its tagName. 
* 
* Retrieve the first Element Node(Root Node) of the   
* DOM object and check the string returned by the            
* "getNodeName()" method.   It should be equal to its
* tagName. 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=251">http://www.w3.org/Bugs/Public/show_bug.cgi?id=251</a>
*/
class Node_Element_Node_Name_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodeelementnodename")
 void run() throws Throwable {
  Document doc;
  Element elementNode;
  String elementName;
  doc = (Document) load("staff", false);
  elementNode = doc.getDocumentElement();
  elementName = elementNode.getNodeName();
  if (("image/svg+xml".equals(getContentType()))) {
   assertEquals("svg", elementName, "svgNodeName");
  } else {
   assertEquals("staff", elementName, "nodeElementNodeNameAssert1");
  }
 }
}