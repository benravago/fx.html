package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The dateTime attribute specifies the date and time of the change. 
* Retrieve the dateTime attribute of the DEL element and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-88432678">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-88432678</a>
*/
class HTML_Mod_Element_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "mod", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLModElement04")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vdatetime;
  Document doc;
  doc = (Document) load("mod", false);
  nodeList = doc.getElementsByTagName("del");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vdatetime = ((HTMLModElement) /*Node */testNode).getDateTime();
  assertEquals("January 2, 2002", vdatetime, "dateTimeLink");
 }
}