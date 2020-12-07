package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The valueType attribute specifies information about the meaning of the
* value specified by the value attribute.
* Retrieve the valueType attribute and examine its value.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-23931872">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-23931872</a>
*/
class HTML_Param_Element_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "param", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLParamElement03")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vvaluetype;
  Document doc;
  doc = (Document) load("param", false);
  nodeList = doc.getElementsByTagName("param");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vvaluetype = ((HTMLParamElement) /*Node */testNode).getValueType();
  assertEquals("ref", vvaluetype, "valueTypeLink");
 }
}