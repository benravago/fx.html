package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "createElement(tagName)" method creates an Element 
* of the type specified.
* Retrieve the entire DOM document and invoke its 
* "createElement(tagName)" method with tagName="address".
* The method should create an instance of an Element node
* whose tagName is "address".  The NodeName, NodeType 
* and NodeValue are returned.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-2141741547">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-2141741547</a>
*/
class Document_Create_Element_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/documentcreateelement")
 void run() throws Throwable {
  Document doc;
  Element newElement;
  String newElementName;
  int newElementType;
  String newElementValue;
  doc = (Document) load("staff", true);
  newElement = doc.createElement("address");
  newElementName = newElement.getNodeName();
  assertEquals("address", newElementName, "name");
  newElementType = (int) newElement.getNodeType();
  assertEquals(1, newElementType, "type");
  newElementValue = newElement.getNodeValue();
  assertNull(newElementValue, "valueInitiallyNull");
 }
}