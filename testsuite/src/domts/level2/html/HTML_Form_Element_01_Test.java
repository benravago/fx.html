package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The elements attribute specifies a collection of all control element
* in the form. 
* Retrieve the elements attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-76728479">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-76728479</a>
*/
class HTML_Form_Element_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "form", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLFormElement01")
 void run() throws Throwable {
  NodeList nodeList;
  HTMLCollection elementnodeList;
  Node testNode;
  int velements;
  Document doc;
  doc = (Document) load("form", false);
  nodeList = doc.getElementsByTagName("form");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  elementnodeList = ((HTMLFormElement) /*Node */testNode).getElements();
  velements = (int) elementnodeList.getLength();
  assertEquals(3, velements, "elementsLink");
 }
}