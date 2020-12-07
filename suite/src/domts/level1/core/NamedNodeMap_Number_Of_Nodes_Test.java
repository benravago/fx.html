package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getLength()" method returns the number of nodes
* in the map. 
* 
* Retrieve the second employee and create a NamedNodeMap 
* listing of the attributes of the last child.  Once the
* list is created an invocation of the "getLength()"
* method is executed.  The number of nodes should be 2.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-6D0FB19E">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-6D0FB19E</a>
*/
class NamedNodeMap_Number_Of_Nodes_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/namednodemapnumberofnodes")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node testEmployee;
  NamedNodeMap attributes;
  int length;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("address");
  testEmployee = elementList.item(2);
  attributes = testEmployee.getAttributes();
  length = (int) attributes.getLength();
  assertEquals(2, length, "length");
 }
}