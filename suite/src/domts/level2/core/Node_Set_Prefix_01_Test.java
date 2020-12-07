package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method setPrefix sets the namespace prefix of this node.  Note that setting this attribute, 
* when permitted, changes the nodeName attribute, which holds the qualified name, as well as the 
* tagName and name attributes of the Element and Attr interfaces, when applicable.
* 
* Create a new element node with a namespace prefix.  Add it to a new DocumentFragment Node without
* a prefix.  Call setPrefix on the elemen node.  Check if the prefix was set correctly on the element.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix</a>
*/
class Node_Set_Prefix_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/nodesetprefix01")
 void run() throws Throwable {
  Document doc;
  DocumentFragment docFragment;
  Element element;
  String elementTagName;
  String elementNodeName;
  Node appendedChild;
  doc = (Document) load("staff", true);
  docFragment = doc.createDocumentFragment();
  element = doc.createElementNS("http://www.w3.org/DOM/Test", "emp:address");
  appendedChild = docFragment.appendChild(element);
  element.setPrefix("dmstc");
  elementTagName = element.getTagName();
  elementNodeName = element.getNodeName();
  assertEquals("dmstc:address", elementTagName, "nodesetprefix01_tagname");
  assertEquals("dmstc:address", elementNodeName, "nodesetprefix01_nodeName");
 }
}