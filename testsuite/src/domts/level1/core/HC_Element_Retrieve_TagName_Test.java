package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getElementsByTagName()" method returns a NodeList 
* of all descendant elements with a given tagName.    
* 
* Invoke the "getElementsByTagName()" method and create
* a NodeList of "code" elements.  Retrieve the second 
* "code" element in the list and return the NodeName. 
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-104682815">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-104682815</a>
*/
class HC_Element_Retrieve_TagName_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_elementretrievetagname")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node testEmployee;
  String strong;
  doc = (Document) load("hc_staff", false);
  elementList = doc.getElementsByTagName("code");
  testEmployee = elementList.item(1);
  strong = testEmployee.getNodeName();
  assertTrue(equalsAutoCase("element", "code", strong), "nodename");
  strong = ((Element) /*Node */testEmployee).getTagName();
  assertTrue(equalsAutoCase("element", "code", strong), "tagname");
 }
}