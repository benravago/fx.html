package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Retrieve the entire DOM document and invoke its 
* "createAttribute(name)" method.  It should create a  
* new Attribute node with the given name. The name, value
* and type of the newly created object are retrieved and
* output.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1084891198">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1084891198</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=236">http://www.w3.org/Bugs/Public/show_bug.cgi?id=236</a>
* @see <a href="http://lists.w3.org/Archives/Public/www-dom-ts/2003Jun/0011.html">http://lists.w3.org/Archives/Public/www-dom-ts/2003Jun/0011.html</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=243">http://www.w3.org/Bugs/Public/show_bug.cgi?id=243</a>
*/
class HC_Document_Create_Attribute_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_documentcreateattribute")
 void run() throws Throwable {
  Document doc;
  Attr newAttrNode;
  String attrValue;
  String attrName;
  int attrType;
  doc = (Document) load("hc_staff", true);
  newAttrNode = doc.createAttribute("title");
  attrValue = newAttrNode.getNodeValue();
  assertEquals("", attrValue, "value");
  attrName = newAttrNode.getNodeName();
  assertTrue(equalsAutoCase("attribute", "title", attrName), "name");
  attrType = (int) newAttrNode.getNodeType();
  assertEquals(2, attrType, "type");
 }
}