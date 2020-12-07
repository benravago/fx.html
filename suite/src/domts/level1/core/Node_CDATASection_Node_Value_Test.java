package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The string returned by the "getNodeValue()" method for a 
* CDATASection Node is the content of the CDATASection. 
* 
* Retrieve the CDATASection node inside the second child
* of the second employee and check the string returned 
* by the "getNodeValue()" method.   It should be equal to 
* "This is a CDATA Section with EntityReference number 2 
* &ent2;".
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D080">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D080</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-667469212">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-667469212</a>
*/
class Node_CDATASection_Node_Value_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setCoalescing(false);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodecdatasectionnodevalue")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element cdataName;
  NodeList childList;
  Node child;
  String cdataNodeValue;
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("name");
  cdataName = (Element) elementList.item(1);
  childList = cdataName.getChildNodes();
  child = childList.item(1);
  if ((child == null)) {
   child = doc.createCDATASection("This is a CDATASection with EntityReference number 2 &ent2;");
  }
  cdataNodeValue = child.getNodeValue();
  assertEquals("This is a CDATASection with EntityReference number 2 &ent2;", cdataNodeValue, "value");
 }
}