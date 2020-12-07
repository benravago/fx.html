package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Create a new DocumentFragment and add a newly created Element node(with one attribute).  
* Once the element is added, its attribute should be available as an attribute associated 
* with an Element within a DocumentFragment.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-35CB04B5">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-35CB04B5</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68F082">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68F082</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-B63ED1A3">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-B63ED1A3</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=236">http://www.w3.org/Bugs/Public/show_bug.cgi?id=236</a>
* @see <a href="http://lists.w3.org/Archives/Public/www-dom-ts/2003Jun/0011.html">http://lists.w3.org/Archives/Public/www-dom-ts/2003Jun/0011.html</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=184">http://www.w3.org/Bugs/Public/show_bug.cgi?id=184</a>
*/
class HC_Attr_Create_DocumentFragment_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_attrcreatedocumentfragment")
 void run() throws Throwable {
  Document doc;
  DocumentFragment docFragment;
  Element newOne;
  Node domesticNode;
  NamedNodeMap attributes;
  Attr attribute;
  String attrName;
  Node appendedChild;
  int langAttrCount = 0;
  doc = (Document) load("hc_staff", true);
  docFragment = doc.createDocumentFragment();
  newOne = doc.createElement("html");
  newOne.setAttribute("lang", "EN");
  appendedChild = docFragment.appendChild(newOne);
  domesticNode = docFragment.getFirstChild();
  attributes = domesticNode.getAttributes();
  for (int indexN10078 = 0; indexN10078 < attributes.getLength(); indexN10078++) {
   attribute = (Attr) attributes.item(indexN10078);
   attrName = attribute.getNodeName();
   if (equalsAutoCase("attribute", "lang", attrName)) {
    langAttrCount += 1;
   }
  }
  assertEquals(1, langAttrCount, "hasLangAttr");
 }
}