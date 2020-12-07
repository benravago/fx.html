package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "createDocumentFragment()" method creates an empty 
* DocumentFragment object.
* Retrieve the entire DOM document and invoke its 
* "createDocumentFragment()" method.  The content, name, 
* type and value of the newly created object are output.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-35CB04B5">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-35CB04B5</a>
*/
class HC_Document_Create_DocumentFragment_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_documentcreatedocumentfragment")
 void run() throws Throwable {
  Document doc;
  DocumentFragment newDocFragment;
  NodeList children;
  int length;
  String newDocFragmentName;
  int newDocFragmentType;
  String newDocFragmentValue;
  doc = (Document) load("hc_staff", true);
  newDocFragment = doc.createDocumentFragment();
  children = newDocFragment.getChildNodes();
  length = (int) children.getLength();
  assertEquals(0, length, "length");
  newDocFragmentName = newDocFragment.getNodeName();
  assertEquals("#document-fragment", newDocFragmentName, "strong");
  newDocFragmentType = (int) newDocFragment.getNodeType();
  assertEquals(11, newDocFragmentType, "type");
  newDocFragmentValue = newDocFragment.getNodeValue();
  assertNull(newDocFragmentValue, "value");
 }
}