package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The URI of the linked resource.
* The value of attribute href of the anchor element is read and checked against the expected value.
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-88517319">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-88517319</a>
*/
class Anchor_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "anchor", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/anchor04")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vhref;
  Node doc;
  doc = (Node) load("anchor", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("a");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vhref = ((HTMLAnchorElement) /*Node */testNode).getHref();
  assertTrue(equalsURI(null, null, null, "submit.gif", null, null, null, Boolean.TRUE, vhref), "hrefLink");
 }
}