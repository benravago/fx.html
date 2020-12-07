package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Create a document fragment with an empty text node, after normalization there should be no child nodes.
* were combined.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-F68D095">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-F68D095</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-B63ED1A3">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-B63ED1A3</a>
*/
class HC_Node_DocumentFragment_Normalize_2_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/hc_nodedocumentfragmentnormalize2")
 void run() throws Throwable {
  Document doc;
  DocumentFragment docFragment;
  String nodeValue;
  Text txtNode;
  Node retval;
  doc = (Document) load("hc_staff", true);
  docFragment = doc.createDocumentFragment();
  txtNode = doc.createTextNode("");
  retval = docFragment.appendChild(txtNode);
  docFragment.normalize();
  txtNode = (Text) docFragment.getFirstChild();
  assertNull(txtNode, "noChild");
 }
}