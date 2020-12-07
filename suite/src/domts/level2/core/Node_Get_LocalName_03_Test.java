package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method getLocalName returns the local part of the qualified name of this node.
* 
* Ceate two new element nodes and atribute nodes, with and without namespace prefixes.
* Retreive the local part of their qualified names using getLocalName and verrify
* if it is correct.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSLocalN">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSLocalN</a>
*/
class Node_Get_LocalName_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/nodegetlocalname03")
 void run() throws Throwable {
  Document doc;
  Element element;
  Element qelement;
  Attr attr;
  Attr qattr;
  String localElemName;
  String localQElemName;
  String localAttrName;
  String localQAttrName;
  doc = (Document) load("staff", false);
  element = doc.createElementNS("http://www.w3.org/DOM/Test/elem", "elem");
  qelement = doc.createElementNS("http://www.w3.org/DOM/Test/elem", "qual:qelem");
  attr = doc.createAttributeNS("http://www.w3.org/DOM/Test/attr", "attr");
  qattr = doc.createAttributeNS("http://www.w3.org/DOM/Test/attr", "qual:qattr");
  localElemName = element.getLocalName();
  localQElemName = qelement.getLocalName();
  localAttrName = attr.getLocalName();
  localQAttrName = qattr.getLocalName();
  assertEquals("elem", localElemName, "nodegetlocalname03_localElemName");
  assertEquals("qelem", localQElemName, "nodegetlocalname03_localQElemName");
  assertEquals("attr", localAttrName, "nodegetlocalname03_localAttrName");
  assertEquals("qattr", localQAttrName, "nodegetlocalname03_localQAttrName");
 }
}