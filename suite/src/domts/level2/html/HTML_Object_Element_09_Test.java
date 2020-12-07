package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The declare attribute specifies this object should be declared only and  
* no instance of it should be created.
* Retrieve the declare attribute of the second OBJECT element and examine
* its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-942770">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-942770</a>
*/
class HTML_Object_Element_09_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "object", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLObjectElement09")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  boolean vdeclare;
  Document doc;
  doc = (Document) load("object", false);
  nodeList = doc.getElementsByTagName("object");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(1);
  vdeclare = ((HTMLObjectElement) /*Node */testNode).getDeclare();
  assertTrue(vdeclare, "declareLink");
 }
}