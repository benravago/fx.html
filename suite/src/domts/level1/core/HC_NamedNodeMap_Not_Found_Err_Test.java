package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "removeNamedItem(name)" method raises a 
* NOT_FOUND_ERR DOMException if there is not a node
* named "strong" in the map.
* 
* Create a NamedNodeMap object from the attributes of the
* last child of the third employee and attempt to remove
* the "lang" attribute.  There is not a node named
* "lang" in the list and therefore the desired   
* exception should be raised.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='INUSE_ATTRIBUTE_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='INUSE_ATTRIBUTE_ERR'])</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-D58B193">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-D58B193</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-D58B193')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INUSE_ATTRIBUTE_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-D58B193')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INUSE_ATTRIBUTE_ERR'])</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=243">http://www.w3.org/Bugs/Public/show_bug.cgi?id=243</a>
*/
class HC_NamedNodeMap_Not_Found_Err_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_namednodemapnotfounderr")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testEmployee;
  NamedNodeMap attributes;
  Node removedNode;
  doc = (Document) load("hc_staff", true);
  elementList = doc.getElementsByTagName("acronym");
  testEmployee = (Element) elementList.item(2);
  attributes = testEmployee.getAttributes();
  {
   boolean success = false;
   try {
    removedNode = attributes.removeNamedItem("lang");
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NOT_FOUND_ERR);
   }
   assertTrue(success, "throw_NOT_FOUND_ERR");
  }
 }
}