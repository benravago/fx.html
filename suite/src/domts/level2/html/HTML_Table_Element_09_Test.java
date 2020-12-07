package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The tBodies attribute returns a collection of all the defined 
* table bodies.
* Retrieve the tBodies attribute from the third TABLE element and
* examine the items of the returned collection. Tests multiple TBODY
* elements. 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-63206416">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-63206416</a>
*/
class HTML_Table_Element_09_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "table", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableElement09")
 void run() throws Throwable {
  NodeList nodeList;
  HTMLCollection tbodiesnodeList;
  Node testNode;
  Document doc;
  String tbodiesName;
  Node vtbodies;
  List result = new ArrayList();
  List expectedOptions = new ArrayList();
  expectedOptions.add("tbody");
  expectedOptions.add("tbody");
  expectedOptions.add("tbody");
  doc = (Document) load("table", false);
  nodeList = doc.getElementsByTagName("table");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(2);
  tbodiesnodeList = ((HTMLTableElement) /*Node */testNode).getTBodies();
  for (int indexN10066 = 0; indexN10066 < tbodiesnodeList.getLength(); indexN10066++) {
   vtbodies = (Node) tbodiesnodeList.item(indexN10066);
   tbodiesName = vtbodies.getNodeName();
   result.add(tbodiesName);
  }
  assertTrue(equalsAutoCase("element", expectedOptions, result), "tbodiesLink");
 }
}