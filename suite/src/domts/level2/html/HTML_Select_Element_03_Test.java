package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The selectedIndex attribute specifies the ordinal index of the selected  
* option.  If no element is selected -1 is returned.
* Retrieve the selectedIndex attribute from the second SELECT element and 
* examine its value.  
* Per http://www.w3.org/TR/html401/interact/forms.html#h-17.6.1,
* without an explicit selected attribute, user agent behavior is 
* undefined.  There is no way to coerce no option to be selected.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-85676760">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-85676760</a>
*/
class HTML_Select_Element_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "select", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLSelectElement03")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  int vselectedindex;
  Document doc;
  doc = (Document) load("select", false);
  nodeList = doc.getElementsByTagName("select");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(1);
  vselectedindex = (int) ((HTMLSelectElement) /*Node */testNode).getSelectedIndex();
 }
}