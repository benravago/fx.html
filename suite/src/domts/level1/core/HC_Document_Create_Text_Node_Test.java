package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "createTextNode(data)" method creates a Text node 
* given the specfied string.
* Retrieve the entire DOM document and invoke its 
* "createTextNode(data)" method.  It should create a 
* new Text node whose "data" is the specified string.
* The NodeName and NodeType are also checked.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1975348127">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1975348127</a>
*/
class HC_Document_Create_Text_Node_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_documentcreatetextnode")
 void run() throws Throwable {
  Document doc;
  Text newTextNode;
  String newTextName;
  String newTextValue;
  int newTextType;
  doc = (Document) load("hc_staff", true);
  newTextNode = doc.createTextNode("This is a new Text node");
  newTextValue = newTextNode.getNodeValue();
  assertEquals("This is a new Text node", newTextValue, "value");
  newTextName = newTextNode.getNodeName();
  assertEquals("#text", newTextName, "strong");
  newTextType = (int) newTextNode.getNodeType();
  assertEquals(3, newTextType, "type");
 }
}