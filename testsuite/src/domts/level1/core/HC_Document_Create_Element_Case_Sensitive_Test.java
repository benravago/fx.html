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
* equal to "acronym" and once for tagName equal to "ACRONYM"
* Each call should create a distinct Element node.  The
* newly created Elements are then assigned attributes 
* that are retrieved.
* Modified on 27 June 2003 to avoid setting an invalid style
* values and checked the node names to see if they matched expectations.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-2141741547">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-2141741547</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=243">http://www.w3.org/Bugs/Public/show_bug.cgi?id=243</a>
*/
class HC_Document_Create_Element_Case_Sensitive_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_documentcreateelementcasesensitive")
 void run() throws Throwable {
  Document doc;
  Element newElement1;
  Element newElement2;
  String attribute1;
  String attribute2;
  String nodeName1;
  String nodeName2;
  doc = (Document) load("hc_staff", true);
  newElement1 = doc.createElement("ACRONYM");
  newElement2 = doc.createElement("acronym");
  newElement1.setAttribute("lang", "EN");
  newElement2.setAttribute("title", "Dallas");
  attribute1 = newElement1.getAttribute("lang");
  attribute2 = newElement2.getAttribute("title");
  assertEquals("EN", attribute1, "attrib1");
  assertEquals("Dallas", attribute2, "attrib2");
  nodeName1 = newElement1.getNodeName();
  nodeName2 = newElement2.getNodeName();
  assertTrue(equalsAutoCase("element", "ACRONYM", nodeName1), "nodeName1");
  assertTrue(equalsAutoCase("element", "acronym", nodeName2), "nodeName2");
 }
}