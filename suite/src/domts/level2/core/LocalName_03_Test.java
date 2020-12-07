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
* Retrieve the first employeeId node and get the first child of this node.
* Since the first child is Text node invoking the "getLocalName()"   
* method will cause "null" to be returned. 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSLocalN">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSLocalN</a>
*/
class LocalName_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/localName03")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node testEmployee;
  Node textNode;
  String localName;
  doc = (Document) load("staffNS", false);
  elementList = doc.getElementsByTagName("employeeId");
  testEmployee = elementList.item(0);
  textNode = testEmployee.getFirstChild();
  localName = textNode.getLocalName();
  assertNull(localName, "textNodeLocalName");
 }
}