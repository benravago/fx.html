package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The cite attribute specifies a URI designating a source document 
* or message. 
* Retrieve the cite attribute from the BLOCKQUOTE element and 
* examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-53895598">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-53895598</a>
*/
class HTML_Quote_Element_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "quote", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLQuoteElement02")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vcite;
  Document doc;
  doc = (Document) load("quote", false);
  nodeList = doc.getElementsByTagName("blockquote");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vcite = ((HTMLQuoteElement) /*Node */testNode).getCite();
  assertTrue(equalsURI(null, null, null, "BLOCKQUOTE.html", null, null, null, null, vcite), "citeLink");
 }
}