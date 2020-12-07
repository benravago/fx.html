package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "setNodeValue()" method changes the character data 
* currently stored in the node.
* Retrieve the character data from the second child 
* of the first employee and invoke the "setNodeValue()" 
* method, call "getData()" and compare.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-72AB8359">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-72AB8359</a>
*/
class CharacterData_Set_Node_Value_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/characterdatasetnodevalue")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node nameNode;
  CharacterData child;
  String childData;
  String childValue;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("name");
  nameNode = elementList.item(0);
  child = (CharacterData) nameNode.getFirstChild();
  child.setNodeValue("Marilyn Martin");
  childData = child.getData();
  assertEquals("Marilyn Martin", childData, "data");
  childValue = child.getNodeValue();
  assertEquals("Marilyn Martin", childValue, "value");
 }
}