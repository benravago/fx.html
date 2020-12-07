package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getNodeType()" method for a Document Node
* returns the constant value 9.
* Retrieve the document and invoke the "getNodeType()" 
* method.   The method should return 9. 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#i-Document">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#i-Document</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-111237558">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-111237558</a>
*/
class Node_Document_Node_Type_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodedocumentnodetype")
 void run() throws Throwable {
  Document doc;
  int nodeType;
  doc = (Document) load("staff", false);
  nodeType = (int) doc.getNodeType();
  assertEquals(9, nodeType, "nodeDocumentNodeTypeAssert1");
 }
}