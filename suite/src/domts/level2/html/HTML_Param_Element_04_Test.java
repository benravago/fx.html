package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The type attribute specifies the content type for the value attribute
* when valuetype has the value ref.
* Retrieve the type attribute and examine its value.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-18179888">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-18179888</a>
*/
class HTML_Param_Element_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "param", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLParamElement04")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vtype;
  Document doc;
  doc = (Document) load("param", false);
  nodeList = doc.getElementsByTagName("param");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vtype = ((HTMLParamElement) /*Node */testNode).getType();
  assertEquals("image/gif", vtype, "typeLink");
 }
}