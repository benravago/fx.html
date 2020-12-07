package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method getAttributeNodeNS retrieves an Attr node by local name and namespace URI.
* Using the getAttributeNodeNS, retrieve and verify the value of the default
* attribute node.
* 
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElGetAtNodeNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElGetAtNodeNS</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=259">http://www.w3.org/Bugs/Public/show_bug.cgi?id=259</a>
*/
class Element_Get_Attribute_Node_NS_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  setValidating(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/elementgetattributenodens03")
 void run() throws Throwable {
  Document doc;
  Element element;
  Attr attribute;
  String attrValue;
  NodeList childList;
  String nullNS = null;
  doc = (Document) load("staffNS", false);
  childList = doc.getElementsByTagNameNS("http://www.nist.gov", "employee");
  element = (Element) childList.item(1);
  attribute = element.getAttributeNodeNS(nullNS, "defaultAttr");
  attrValue = attribute.getNodeValue();
  assertEquals("defaultVal", attrValue, "elementgetattributenodens03");
 }
}