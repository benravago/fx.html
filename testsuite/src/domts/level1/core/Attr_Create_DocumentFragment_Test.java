package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Attr nodes may be associated with Element nodes contained within a DocumentFragment.
* Create a new DocumentFragment and add a newly created Element node(with one attribute).  
* Once the element is added, its attribute should be available as an attribute associated 
* with an Element within a DocumentFragment.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-35CB04B5">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-35CB04B5</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68F082">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68F082</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-B63ED1A3">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-B63ED1A3</a>
*/
class Attr_Create_DocumentFragment_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/attrcreatedocumentfragment")
 void run() throws Throwable {
  Document doc;
  DocumentFragment docFragment;
  Element newOne;
  Node domesticNode;
  NamedNodeMap domesticAttr;
  Attr attrs;
  String attrName;
  Node appendedChild;
  doc = (Document) load("staff", true);
  docFragment = doc.createDocumentFragment();
  newOne = doc.createElement("newElement");
  newOne.setAttribute("newdomestic", "Yes");
  appendedChild = docFragment.appendChild(newOne);
  domesticNode = docFragment.getFirstChild();
  domesticAttr = domesticNode.getAttributes();
  attrs = (Attr) domesticAttr.item(0);
  attrName = attrs.getName();
  assertEquals("newdomestic", attrName, "attrCreateDocumentFragmentAssert");
 }
}