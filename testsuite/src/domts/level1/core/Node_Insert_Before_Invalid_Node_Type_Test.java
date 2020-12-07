package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "insertBefore(newChild,refChild)" method raises a 
* HIERARCHY_REQUEST_ERR DOMException if this node is of
* a type that does not allow children of the type "newChild"
* to be inserted.
* 
* Retrieve the root node and attempt to insert a newly
* created Attr node.   An Element node cannot have children
* of the "Attr" type, therefore the desired exception
* should be raised.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='HIERARCHY_REQUEST_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='HIERARCHY_REQUEST_ERR'])</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-952280727">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-952280727</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-952280727')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='HIERARCHY_REQUEST_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-952280727')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='HIERARCHY_REQUEST_ERR'])</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-952280727">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-952280727</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=249">http://www.w3.org/Bugs/Public/show_bug.cgi?id=249</a>
*/
class Node_Insert_Before_Invalid_Node_Type_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodeinsertbeforeinvalidnodetype")
 void run() throws Throwable {
  Document doc;
  Element rootNode;
  Node newChild;
  NodeList elementList;
  Node refChild;
  Node insertedNode;
  doc = (Document) load("staff", true);
  rootNode = doc.getDocumentElement();
  newChild = doc.createAttribute("newAttribute");
  elementList = doc.getElementsByTagName("employee");
  refChild = elementList.item(1);
  {
   boolean success = false;
   try {
    insertedNode = rootNode.insertBefore(newChild, refChild);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.HIERARCHY_REQUEST_ERR);
   }
   assertTrue(success, "throw_HIERARCHY_REQUEST_ERR");
  }
 }
}