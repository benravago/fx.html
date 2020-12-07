package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The tagName parameter in the "createElement(tagName)"
* method is case-sensitive for XML documents.
* Retrieve the entire DOM document and invoke its 
* "createElement(tagName)" method twice.  Once for tagName
* equal to "address" and once for tagName equal to "ADDRESS"
* Each call should create a distinct Element node.  The
* newly created Elements are then assigned attributes 
* that are retrieved.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-2141741547">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-2141741547</a>
*/
class Document_Create_Element_Case_Sensitive_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/documentcreateelementcasesensitive")
 void run() throws Throwable {
  Document doc;
  Element newElement1;
  Element newElement2;
  String attribute1;
  String attribute2;
  doc = (Document) load("staff", true);
  newElement1 = doc.createElement("ADDRESS");
  newElement2 = doc.createElement("address");
  newElement1.setAttribute("district", "Fort Worth");
  newElement2.setAttribute("county", "Dallas");
  attribute1 = newElement1.getAttribute("district");
  attribute2 = newElement2.getAttribute("county");
  assertEquals("Fort Worth", attribute1, "attrib1");
  assertEquals("Dallas", attribute2, "attrib2");
 }
}