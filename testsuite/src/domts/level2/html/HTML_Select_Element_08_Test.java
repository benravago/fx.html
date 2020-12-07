package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The options attribute returns a collection of OPTION elements contained
* by this element.
* Retrieve the options attribute from the first SELECT element and
* examine the items of the returned collection. 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-30606413">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-30606413</a>
*/
class HTML_Select_Element_08_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "select", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLSelectElement08")
 void run() throws Throwable {
  NodeList nodeList;
  HTMLCollection optionsnodeList;
  Node testNode;
  int vareas;
  Document doc;
  String optionName;
  Node voption;
  List result = new ArrayList();
  List expectedOptions = new ArrayList();
  expectedOptions.add("option");
  expectedOptions.add("option");
  expectedOptions.add("option");
  expectedOptions.add("option");
  expectedOptions.add("option");
  doc = (Document) load("select", false);
  nodeList = doc.getElementsByTagName("select");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(0);
  optionsnodeList = (HTMLCollection) ((HTMLSelectElement) /*Node */testNode).getOptions();
  for (int indexN10070 = 0; indexN10070 < optionsnodeList.getLength(); indexN10070++) {
   voption = (Node) optionsnodeList.item(indexN10070);
   optionName = voption.getNodeName();
   result.add(optionName);
  }
  assertTrue(equalsAutoCase("element", expectedOptions, result), "optionsLink");
 }
}