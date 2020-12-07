package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "createAttribute(name)" method creates an Attribute 
* node of the given name.
* 
* Retrieve the entire DOM document and invoke its 
* "createAttribute(name)" method.  It should create a  
* new Attribute node with the given name. The name, value
* and type of the newly created object are retrieved and
* output.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1084891198">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1084891198</a>
*/
class Document_Create_Attribute_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/documentcreateattribute")
 void run() throws Throwable {
  Document doc;
  Attr newAttrNode;
  String attrValue;
  String attrName;
  int attrType;
  doc = (Document) load("staff", true);
  newAttrNode = doc.createAttribute("district");
  attrValue = newAttrNode.getNodeValue();
  assertEquals("", attrValue, "value");
  attrName = newAttrNode.getNodeName();
  assertEquals("district", attrName, "name");
  attrType = (int) newAttrNode.getNodeType();
  assertEquals(2, attrType, "type");
 }
}