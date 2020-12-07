package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "createElement(tagName)" method creates an Element 
* of the type specified.  In addition, if there are known attributes
* with default values, Attr nodes representing them are automatically
* created and attached to the element.
* Retrieve the entire DOM document and invoke its 
* "createElement(tagName)" method with tagName="address".
* The method should create an instance of an Element node
* whose tagName is "address".  The tagName "address" has an 
* attribute with default values, therefore the newly created element
* will have them.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-2141741547">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-2141741547</a>
* @see <a href="http://lists.w3.org/Archives/Public/www-dom-ts/2002Mar/0002.html">http://lists.w3.org/Archives/Public/www-dom-ts/2002Mar/0002.html</a>
*/
@Disabled("fx")
class Document_Create_Element_Default_Attr_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setValidating(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/documentcreateelementdefaultattr")
 void run() throws Throwable {
  Document doc;
  Element newElement;
  NamedNodeMap defaultAttr;
  Node child;
  String name;
  String value;
  doc = (Document) load("staff", true);
  newElement = doc.createElement("address");
  defaultAttr = newElement.getAttributes();
  child = defaultAttr.item(0);
  assertNotNull(child, "defaultAttrNotNull");
  name = child.getNodeName();
  assertEquals("street", name, "attrName");
  value = child.getNodeValue();
  assertEquals("Yes", value, "attrValue");
  assertTrue(equalsSize(1, defaultAttr), "attrCount");
 }
}