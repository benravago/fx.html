package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getDocumentElement()" method provides direct access 
* to the child node that is the root element of the document.
* Retrieve the entire DOM document and invoke its 
* "getDocumentElement()" method.  It should return an
* Element node whose NodeName is "staff" (or "svg").
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-87CD092">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-87CD092</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=251">http://www.w3.org/Bugs/Public/show_bug.cgi?id=251</a>
*/
class Document_Get_Root_Node_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/documentgetrootnode")
 void run() throws Throwable {
  Document doc;
  Element root;
  String rootName;
  doc = (Document) load("staff", false);
  root = doc.getDocumentElement();
  rootName = root.getNodeName();
  if (("image/svg+xml".equals(getContentType()))) {
   assertEquals("svg", rootName, "svgRootNode");
  } else {
   assertEquals("staff", rootName, "documentGetRootNodeAssert");
  }
 }
}