package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The enctype attribute specifies the content of the submitted form.
* Retrieve the enctype attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-84227810">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-84227810</a>
*/
class HTML_Form_Element_06_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "form", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLFormElement06")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String venctype;
  Document doc;
  doc = (Document) load("form", false);
  nodeList = doc.getElementsByTagName("form");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  venctype = ((HTMLFormElement) /*Node */testNode).getEnctype();
  assertEquals("application/x-www-form-urlencoded", venctype, "enctypeLink");
 }
}