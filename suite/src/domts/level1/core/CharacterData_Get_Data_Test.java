package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getData()" method retrieves the character data 
* currently stored in the node.
* Retrieve the character data from the second child 
* of the first employee and invoke the "getData()" 
* method.  The method returns the character data 
* string.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-72AB8359">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-72AB8359</a>
*/
class CharacterData_Get_Data_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/characterdatagetdata")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node nameNode;
  CharacterData child;
  String childData;
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("name");
  nameNode = elementList.item(0);
  child = (CharacterData) nameNode.getFirstChild();
  childData = child.getData();
  assertEquals("Margaret Martin", childData, "characterdataGetDataAssert");
 }
}