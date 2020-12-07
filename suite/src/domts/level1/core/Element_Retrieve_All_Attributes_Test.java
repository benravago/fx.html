package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getAttributes()" method(Node Interface) may
* be used to retrieve the set of all attributes of an
* element. 
* 
* Create a list of all the attributes of the last child
* of the first employee by using the "getAttributes()"
* method.  Examine the length of the attribute list.  
* This test uses the "getLength()" method from the        
* NameNodeMap interface.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096</a>
* @see <a href="http://lists.w3.org/Archives/Public/www-dom-ts/2002Mar/0002.html">http://lists.w3.org/Archives/Public/www-dom-ts/2002Mar/0002.html</a>
*/
class Element_Retrieve_All_Attributes_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setValidating(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/elementretrieveallattributes")
 void run() throws Throwable {
  Document doc;
  NodeList addressList;
  Node testAddress;
  NamedNodeMap attributes;
  doc = (Document) load("staff", false);
  addressList = doc.getElementsByTagName("address");
  testAddress = addressList.item(0);
  attributes = testAddress.getAttributes();
  assertTrue(equalsSize(2, attributes), "elementRetrieveAllAttributesAssert");
 }
}