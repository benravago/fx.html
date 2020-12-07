package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The cite attribute specifies an URI designating a document that describes
* the reason for the change.
* Retrieve the cite attribute of the INS element and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-75101708">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-75101708</a>
*/
class HTML_Mod_Element_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "mod", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLModElement01")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vcite;
  Document doc;
  doc = (Document) load("mod", false);
  nodeList = doc.getElementsByTagName("ins");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vcite = ((HTMLModElement) /*Node */testNode).getCite();
  assertTrue(equalsURI(null, null, null, "ins-reasons.html", null, null, null, null, vcite), "citeLink");
 }
}