package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getPrefix()" method for a Node
* returns the namespace prefix of the node,
* and for nodes of any type other than ELEMENT_NODE and ATTRIBUTE_NODE
* and nodes created with a DOM Level 1 method, this is null.
* 
* Create an new Element with the createElement() method.
* Invoke the "getPrefix()" method on the newly created element   
* node will cause "null" to be returned. 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix</a>
*/
class Prefix_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/prefix01")
 void run() throws Throwable {
  Document doc;
  Node createdNode;
  String prefix;
  doc = (Document) load("staffNS", false);
  createdNode = doc.createElement("test:employee");
  prefix = createdNode.getPrefix();
  assertNull(prefix, "throw_Null");
 }
}