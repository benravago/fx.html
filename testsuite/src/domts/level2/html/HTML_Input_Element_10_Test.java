package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The maxLength attribute is the maximum number of text characters for text
* fields, when type has the value of Text or Password.
* Retrieve the maxLenght attribute of the 1st INPUT element and examine
* its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-54719353">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-54719353</a>
*/
class HTML_Input_Element_10_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "input", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLInputElement10")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  int vmaxlength;
  Document doc;
  doc = (Document) load("input", false);
  nodeList = doc.getElementsByTagName("input");
  assertTrue(equalsSize(9, nodeList), "Asize");
  testNode = nodeList.item(0);
  vmaxlength = (int) ((HTMLInputElement) /*Node */testNode).getMaxLength();
  assertEquals(5, vmaxlength, "maxlengthLink");
 }
}