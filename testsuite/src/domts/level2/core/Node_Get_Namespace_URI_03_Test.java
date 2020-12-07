package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method getNamespaceURI returns the namespace URI of this node, or null if it is unspecified
* For nodes of any type other than ELEMENT_NODE and ATTRIBUTE_NODE and nodes created with 
* a DOM Level 1 method, such as createElement from the Document interface, this is always null.
* 
* Ceate two new element nodes and atribute nodes, with and without namespace prefixes.
* Retreive their namespaceURI's using getNamespaceURI and verrify if it is correct.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSname">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSname</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=259">http://www.w3.org/Bugs/Public/show_bug.cgi?id=259</a>
*/
class Node_Get_Namespace_URI_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/nodegetnamespaceuri03")
 void run() throws Throwable {
  Document doc;
  Element element;
  Element elementNS;
  Attr attr;
  Attr attrNS;
  String elemNSURI;
  String elemNSURINull;
  String attrNSURI;
  String attrNSURINull;
  String nullNS = null;
  doc = (Document) load("staff", false);
  element = doc.createElementNS(nullNS, "elem");
  elementNS = doc.createElementNS("http://www.w3.org/DOM/Test/elem", "qual:qelem");
  attr = doc.createAttributeNS(nullNS, "attr");
  attrNS = doc.createAttributeNS("http://www.w3.org/DOM/Test/attr", "qual:qattr");
  elemNSURI = elementNS.getNamespaceURI();
  elemNSURINull = element.getNamespaceURI();
  attrNSURI = attrNS.getNamespaceURI();
  attrNSURINull = attr.getNamespaceURI();
  assertEquals("http://www.w3.org/DOM/Test/elem", elemNSURI, "nodegetnamespaceuri03_elemNSURI");
  assertNull(elemNSURINull, "nodegetnamespaceuri03_1");
  assertEquals("http://www.w3.org/DOM/Test/attr", attrNSURI, "nodegetnamespaceuri03_attrNSURI");
  assertNull(attrNSURINull, "nodegetnamespaceuri03_2");
 }
}