package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The accessKey attribute is a single character access key to give access
* to the form control.
* Retrieve the accessKey attribute and examine its value.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-43589892">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-43589892</a>
*/
class HTML_Label_Element_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "label", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLLabelElement03")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vaccesskey;
  Document doc;
  doc = (Document) load("label", false);
  nodeList = doc.getElementsByTagName("label");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(0);
  vaccesskey = ((HTMLLabelElement) /*Node */testNode).getAccessKey();
  assertEquals("b", vaccesskey, "accesskeyLink");
 }
}