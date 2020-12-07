package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "hasAttributes()" method for a node should 
* return true if the node has attributes. 
* Retrieve the first address node and the "hasAttributes()" method
* should return true since the node has "domestic" as an attribute.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeHasAttrs">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeHasAttrs</a>
*/
class Has_Attributes_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/hasAttributes02")
 void run() throws Throwable {
  Document doc;
  NodeList addrList;
  Node addrNode;
  boolean state;
  doc = (Document) load("staff", false);
  addrList = doc.getElementsByTagName("address");
  addrNode = addrList.item(0);
  state = addrNode.hasAttributes();
  assertTrue(state, "throw_True");
 }
}