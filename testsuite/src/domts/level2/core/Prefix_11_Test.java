package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "setPrefix(prefix)" method raises a 
* NAMESPACE_ERR DOMException if the specified
* prefix is set on a node with a namespaceURI that is null.
* 
* Attempt to insert a new namespace prefix on the second employee node.
* An exception should be raised since the namespace prefix is set
* on a node whose namespaceURI is null. 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='NAMESPACE_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='NAMESPACE_ERR'])</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#">http://www.w3.org/TR/DOM-Level-2-Core/core#</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('')/setraises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NAMESPACE_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('')/setraises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NAMESPACE_ERR'])</a>
*/
class Prefix_11_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/prefix11")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  String namespaceURI;
  doc = (Document) load("staffNS", true);
  elementList = doc.getElementsByTagName("employee");
  employeeNode = elementList.item(1);
  namespaceURI = employeeNode.getNamespaceURI();
  {
   boolean success = false;
   try {
    employeeNode.setPrefix("employee1");
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NAMESPACE_ERR);
   }
   assertTrue(success, "throw_NAMESPACE_ERR");
  }
 }
}