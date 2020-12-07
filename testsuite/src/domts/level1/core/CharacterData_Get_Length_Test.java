package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getLength()" method returns the number of characters 
* stored in this nodes data.
* Retrieve the character data from the second 
* child of the first employee and examine the 
* value returned by the getLength() method.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-72AB8359">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-72AB8359</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-7D61178C">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-7D61178C</a>
*/
class CharacterData_Get_Length_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/characterdatagetlength")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node nameNode;
  CharacterData child;
  String childValue;
  int childLength;
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("name");
  nameNode = elementList.item(0);
  child = (CharacterData) nameNode.getFirstChild();
  childValue = child.getData();
  childLength = childValue.length();
  assertEquals(15, childLength, "characterdataGetLengthAssert");
 }
}