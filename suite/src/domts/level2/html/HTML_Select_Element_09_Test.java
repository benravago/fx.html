package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The disabled attribute indicates that this control is not available
* within this context.
* Retrieve the disabled attribute from the third SELECT element
* and examine its value.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-79102918">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-79102918</a>
*/
class HTML_Select_Element_09_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "select", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLSelectElement09")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  boolean vdisabled;
  Document doc;
  doc = (Document) load("select", false);
  nodeList = doc.getElementsByTagName("select");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(2);
  vdisabled = ((HTMLSelectElement) /*Node */testNode).getDisabled();
  assertTrue(vdisabled, "disabledLink");
 }
}