package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "insertBefore(newChild,refChild)" method raises a 
* HIERARCHY_REQUEST_ERR DOMException if the node to be
* inserted is one of this nodes ancestors.
* 
* Retrieve the second employee and attempt to insert a
* node that is one of its ancestors(root node).   An 
* attempt to insert such a node should raise the 
* desired exception.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='HIERARCHY_REQUEST_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='HIERARCHY_REQUEST_ERR'])</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-952280727">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-952280727</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-952280727')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='HIERARCHY_REQUEST_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-952280727')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='HIERARCHY_REQUEST_ERR'])</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-952280727">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-952280727</a>
*/
class HC_Node_Insert_Before_Node_Ancestor_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodeinsertbeforenodeancestor")
 void run() throws Throwable {
  Document doc;
  Node newChild;
  NodeList elementList;
  Node employeeNode;
  NodeList childList;
  Node refChild;
  Node insertedNode;
  doc = (Document) load("hc_staff", true);
  newChild = doc.getDocumentElement();
  elementList = doc.getElementsByTagName("p");
  employeeNode = elementList.item(1);
  childList = employeeNode.getChildNodes();
  refChild = childList.item(0);
  {
   boolean success = false;
   try {
    insertedNode = employeeNode.insertBefore(newChild, refChild);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.HIERARCHY_REQUEST_ERR);
   }
   assertTrue(success, "throw_HIERARCHY_REQUEST_ERR");
  }
 }
}