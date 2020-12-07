package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getLocalName()" method for a Node
* returns the local part of the qualified name of this node,
* and for nodes of any type other than ELEMENT_NODE and ATTRIBUTE_NODE
* and nodes created with a DOM Level 1 method, this is null.
* 
* Create an new Element with the createElement() method.
* Invoke the "getLocalName()" method on the newly created element  
* node will cause "null" to be returned. 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSLocalN">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSLocalN</a>
*/
class LocalName_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/localName02")
 void run() throws Throwable {
  Document doc;
  Node createdNode;
  String localName;
  doc = (Document) load("staffNS", false);
  createdNode = doc.createElement("test:employee");
  localName = createdNode.getLocalName();
  assertNull(localName, "localNameNull");
 }
}