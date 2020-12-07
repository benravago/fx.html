package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The htmlFor attribute links this label with another form control by
* id attribute.
* Retrieve the htmlFor attribute of the first LABEL element 
* and examine its value.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-96509813">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-96509813</a>
*/
class HTML_Label_Element_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "label", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLLabelElement04")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vhtmlfor;
  Document doc;
  doc = (Document) load("label", false);
  nodeList = doc.getElementsByTagName("label");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(0);
  vhtmlfor = ((HTMLLabelElement) /*Node */testNode).getHtmlFor();
  assertEquals("input1", vhtmlfor, "htmlForLink");
 }
}