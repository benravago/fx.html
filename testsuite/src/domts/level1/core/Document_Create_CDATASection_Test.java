package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "createCDATASection(data)" method creates a new 
* CDATASection node whose value is the specified string.
* Retrieve the entire DOM document and invoke its 
* "createCDATASection(data)" method.  It should create a
* new CDATASection node whose "data" is the specified 
* string.  The content, name and type are retrieved and
* output.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-D26C0AF8">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-D26C0AF8</a>
*/
class Document_Create_CDATASection_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/documentcreatecdatasection")
 void run() throws Throwable {
  Document doc;
  CDATASection newCDATASectionNode;
  String newCDATASectionValue;
  String newCDATASectionName;
  int newCDATASectionType;
  doc = (Document) load("staff", true);
  newCDATASectionNode = doc.createCDATASection("This is a new CDATASection node");
  newCDATASectionValue = newCDATASectionNode.getNodeValue();
  assertEquals("This is a new CDATASection node", newCDATASectionValue, "nodeValue");
  newCDATASectionName = newCDATASectionNode.getNodeName();
  assertEquals("#cdata-section", newCDATASectionName, "nodeName");
  newCDATASectionType = (int) newCDATASectionNode.getNodeType();
  assertEquals(4, newCDATASectionType, "nodeType");
 }
}