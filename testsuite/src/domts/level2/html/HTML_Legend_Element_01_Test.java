package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The form attribute returns the FORM element containing this control. 
* Retrieve the form attribute from the first LEGEND element
* and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-29594519">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-29594519</a>
*/
class HTML_Legend_Element_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "legend", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLLegendElement01")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vform;
  HTMLFormElement fNode;
  Document doc;
  doc = (Document) load("legend", false);
  nodeList = doc.getElementsByTagName("legend");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(0);
  fNode = ((HTMLLegendElement) /*Node */testNode).getForm();
  vform = fNode.getId();
  assertEquals("form1", vform, "formLink");
 }
}