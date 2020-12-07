package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The profile attribute specifies a URI designating a metadata profile. 
* Retrieve the profile attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-96921909">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-96921909</a>
*/
class HTML_Head_Element_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "head", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLHeadElement01")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vprofile;
  Document doc;
  doc = (Document) load("head", false);
  nodeList = doc.getElementsByTagName("head");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vprofile = ((HTMLHeadElement) /*Node */testNode).getProfile();
  assertTrue(equalsURI(null, null, null, "profile", null, null, null, null, vprofile), "profileLink");
 }
}