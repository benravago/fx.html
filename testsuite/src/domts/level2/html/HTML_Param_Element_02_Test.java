package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The value attribute specifies the value of the run-time parameter.
* Retrieve the value attribute and examine its value.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-77971357">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-77971357</a>
*/
class HTML_Param_Element_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "param", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLParamElement02")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vvalue;
  Document doc;
  doc = (Document) load("param", false);
  nodeList = doc.getElementsByTagName("param");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vvalue = ((HTMLParamElement) /*Node */testNode).getValue();
  assertTrue(equalsURI(null, null, null, "file.gif", null, null, null, null, vvalue), "valueLink");
 }
}