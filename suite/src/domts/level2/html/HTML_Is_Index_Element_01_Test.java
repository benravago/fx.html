package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The form attribute returns the FORM element containing this control. 
* Retrieve the form attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-87069980">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-87069980</a>
*/
class HTML_Is_Index_Element_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "isindex", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLIsIndexElement01")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vform;
  HTMLFormElement fNode;
  Document doc;
  String prompt;
  doc = (Document) load("isindex", false);
  nodeList = doc.getElementsByTagName("isindex");
  testNode = nodeList.item(0);
  assertNotNull(testNode, "notnull");
  prompt = ((HTMLIsIndexElement) /*Node */testNode).getPrompt();
  assertEquals("New Employee: ", prompt, "IsIndex.Prompt");
  fNode = ((HTMLIsIndexElement) /*Node */testNode).getForm();
  assertNotNull(fNode, "formNotNull");
  vform = fNode.getId();
  assertEquals("form1", vform, "formLink");
  assertTrue(equalsSize(2, nodeList), "Asize");
 }
}