package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Retrieve the last CDATASection node located inside the
* second child of the second employee and examine its
* content.  Since the CDATASection interface inherits
* from the CharacterData interface(via the Text node),
* the "getData()" method can be used to access the
* CDATA content.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-72AB8359">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-72AB8359</a>
*/
class CDATASection_Get_Data_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setCoalescing(false);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/cdatasectiongetdata")
 void run() throws Throwable {
  Document doc;
  NodeList nameList;
  Node child;
  Node lastChild;
  String data;
  int nodeType;
  doc = (Document) load("staff", false);
  nameList = doc.getElementsByTagName("name");
  child = nameList.item(1);
  lastChild = child.getLastChild();
  nodeType = (int) lastChild.getNodeType();
  assertEquals(4, nodeType, "isCDATA");
  data = ((CharacterData) /*Node */lastChild).getData();
  assertEquals("This is an adjacent CDATASection with a reference to a tab &tab;", data, "data");
 }
}