package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The string returned by the "getNodeName()" method for a 
* DocumentFragment Node is "#document-frament".
* Retrieve the DOM document and invoke the
* "createDocumentFragment()" method and check the string      
* returned by the "getNodeName()" method.   It should be 
* equal to "#document-fragment".
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-B63ED1A3">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-B63ED1A3</a>
*/
class Node_DocumentFragment_Node_Name_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodedocumentfragmentnodename")
 void run() throws Throwable {
  Document doc;
  DocumentFragment docFragment;
  String documentFragmentName;
  doc = (Document) load("staff", true);
  docFragment = doc.createDocumentFragment();
  documentFragmentName = docFragment.getNodeName();
  assertEquals("#document-fragment", documentFragmentName, "nodeDocumentFragmentNodeNameAssert1");
 }
}