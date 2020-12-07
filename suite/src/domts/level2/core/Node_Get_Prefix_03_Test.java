package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method getPrefix returns the namespace prefix of this node, or null if it is unspecified.
* 
* Ceate two new element nodes and atribute nodes, with and without namespace prefixes.
* Retreive the prefix part of their qualified names using getPrefix and verify
* if it is correct.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix</a>
*/
class Node_Get_Prefix_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/nodegetprefix03")
 void run() throws Throwable {
  Document doc;
  Element element;
  Element qelement;
  Attr attr;
  Attr qattr;
  String elemNoPrefix;
  String elemPrefix;
  String attrNoPrefix;
  String attrPrefix;
  doc = (Document) load("staff", false);
  element = doc.createElementNS("http://www.w3.org/DOM/Test/elem", "elem");
  qelement = doc.createElementNS("http://www.w3.org/DOM/Test/elem", "qual:qelem");
  attr = doc.createAttributeNS("http://www.w3.org/DOM/Test/attr", "attr");
  qattr = doc.createAttributeNS("http://www.w3.org/DOM/Test/attr", "qual:qattr");
  elemNoPrefix = element.getPrefix();
  elemPrefix = qelement.getPrefix();
  attrNoPrefix = attr.getPrefix();
  attrPrefix = qattr.getPrefix();
  assertNull(elemNoPrefix, "nodegetprefix03_1");
  assertEquals("qual", elemPrefix, "nodegetprefix03_2");
  assertNull(attrNoPrefix, "nodegetprefix03_3");
  assertEquals("qual", attrPrefix, "nodegetprefix03_4");
 }
}