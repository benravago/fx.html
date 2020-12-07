package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "setNamedItem(arg)" method raises a
* INUSE_ATTRIBUTE_ERR DOMException if "arg" is an
* Attr that is already in an attribute of another Element.
* Create a NamedNodeMap object from the attributes of the
* last child of the third employee and attempt to add
* an attribute that is already being used by the first
* employee.  This should raise the desired exception.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='INUSE_ATTRIBUTE_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='INUSE_ATTRIBUTE_ERR'])</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1025163788">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1025163788</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-1025163788')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INUSE_ATTRIBUTE_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-1025163788')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INUSE_ATTRIBUTE_ERR'])</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=249">http://www.w3.org/Bugs/Public/show_bug.cgi?id=249</a>
*/
@Disabled("fx")
class HC_NamedNodeMap_InUse_Attribute_Err_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_namednodemapinuseattributeerr")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element firstNode;
  Node testNode;
  NamedNodeMap attributes;
  Attr domesticAttr;
  Attr setAttr;
  Node setNode;
  doc = (Document) load("hc_staff", true);
  elementList = doc.getElementsByTagName("acronym");
  firstNode = (Element) elementList.item(0);
  domesticAttr = doc.createAttribute("title");
  domesticAttr.setValue("Yα");
  setAttr = firstNode.setAttributeNode(domesticAttr);
  elementList = doc.getElementsByTagName("acronym");
  testNode = elementList.item(2);
  attributes = testNode.getAttributes();
  {
   boolean success = false;
   try {
    setNode = attributes.setNamedItem(domesticAttr);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.INUSE_ATTRIBUTE_ERR);
   }
   assertTrue(success, "throw_INUSE_ATTRIBUTE_ERR");
  }
 }
}