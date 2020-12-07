package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* An HTMLOptionsCollection is a list of nodes representing HTML option
* element. 
* The length attribute specifies the length or size of the list.
* Retrieve the first SELECT element and create a HTMLOptionsCollection
* of the OPTION elements.  Check the size of the length of OPTION elements.
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html#HTMLOptionsCollection-length">http://www.w3.org/TR/DOM-Level-2-HTML/html#HTMLOptionsCollection-length</a>
*/
class HTML_Options_Collection_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "optionscollection", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLOptionsCollection01")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  HTMLCollection optionsList;
  int vlength;
  Document doc;
  doc = (Document) load("optionscollection", false);
  nodeList = doc.getElementsByTagName("select");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(0);
  optionsList = ((HTMLSelectElement) /*Node */testNode).getOptions();
  vlength = (int) optionsList.getLength();
  assertEquals(5, vlength, "lengthLink");
 }
}