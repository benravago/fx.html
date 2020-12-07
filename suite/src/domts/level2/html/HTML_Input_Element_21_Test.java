package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* HTMLInputElement.click should change the state of checked on a radio button.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-2651361">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-2651361</a>
*/
class HTML_Input_Element_21_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "input", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLInputElement21")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  Document doc;
  boolean checked;
  doc = (Document) load("input", true);
  nodeList = doc.getElementsByTagName("input");
  assertTrue(equalsSize(9, nodeList), "Asize");
  testNode = nodeList.item(1);
  checked = ((HTMLInputElement) /*Node */testNode).getChecked();
  assertFalse(checked, "notCheckedBeforeClick");
  ((HTMLInputElement) /*Node */testNode).click();
  checked = ((HTMLInputElement) /*Node */testNode).getChecked();
  assertTrue(checked, "checkedAfterClick");
 }
}