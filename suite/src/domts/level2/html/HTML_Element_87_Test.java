package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The lang attribute specifies the language code defined in RFC 1766. 
* Retrieve the lang attribute of the CENTER element and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-59132807">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-59132807</a>
*/
class HTML_Element_87_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "element", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLElement87")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vlang;
  Document doc;
  doc = (Document) load("element", false);
  nodeList = doc.getElementsByTagName("center");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(0);
  vlang = ((HTMLElement) /*Node */testNode).getLang();
  assertEquals("en", vlang, "langLink");
 }
}