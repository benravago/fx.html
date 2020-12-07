package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method hasAttributes returns whether this node (if it is an element) has any attributes.
* Retreive an element node without attributes.  Verify if hasAttributes returns false.
* Retreive another element node with attributes.  Verify if hasAttributes returns true. 
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeHasAttrs">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeHasAttrs</a>
*/
class Node_Has_Attributes_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/nodehasattributes01")
 void run() throws Throwable {
  Document doc;
  Element element;
  NodeList elementList;
  boolean hasAttributes;
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("employee");
  element = (Element) elementList.item(0);
  hasAttributes = element.hasAttributes();
  assertFalse(hasAttributes, "nodehasattributes01_1");
  elementList = doc.getElementsByTagName("address");
  element = (Element) elementList.item(0);
  hasAttributes = element.hasAttributes();
  assertTrue(hasAttributes, "nodehasattributes01_2");
 }
}