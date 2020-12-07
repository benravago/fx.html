package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "hasAttributes()" method for a node should 
* return false if the node does not have an attribute. 
* Retrieve the first "name" node and invoke the "hasAttributes()" method.
* The method should return false since the node does not have an attribute.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeHasAttrs">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeHasAttrs</a>
*/
class Has_Attributes_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/hasAttributes01")
 void run() throws Throwable {
  Document doc;
  NodeList addrList;
  Node addrNode;
  boolean state;
  doc = (Document) load("staff", false);
  addrList = doc.getElementsByTagName("name");
  addrNode = addrList.item(0);
  state = addrNode.hasAttributes();
  assertFalse(state, "throw_False");
 }
}