package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The length attribute specifies the number of options in this select.
* Retrieve the length attribute from the first SELECT element and 
* examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-5933486">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-5933486</a>
*/
class HTML_Select_Element_05_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "select", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLSelectElement05")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  int vlength;
  Document doc;
  doc = (Document) load("select", false);
  nodeList = doc.getElementsByTagName("select");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(0);
  vlength = (int) ((HTMLSelectElement) /*Node */testNode).getLength();
  assertEquals(5, vlength, "lengthLink");
 }
}