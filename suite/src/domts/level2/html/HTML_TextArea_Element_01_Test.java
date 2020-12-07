package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The defaultValue attribute represents the HTML value of the attribute
* when the type attribute has the value of "Text", "File" or "Password".  
* Retrieve the defaultValue attribute of the 2nd TEXTAREA element and examine
* its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-36152213">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-36152213</a>
*/
class HTML_TextArea_Element_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "textarea", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTextAreaElement01")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vdefaultvalue;
  Document doc;
  doc = (Document) load("textarea", false);
  nodeList = doc.getElementsByTagName("textarea");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(1);
  vdefaultvalue = ((HTMLTextAreaElement) /*Node */testNode).getDefaultValue();
  assertEquals("TEXTAREA2", vdefaultvalue, "defaultValueLink");
 }
}