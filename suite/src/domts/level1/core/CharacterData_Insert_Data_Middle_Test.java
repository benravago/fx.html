package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "insertData(offset,arg)" method will insert a string 
* at the specified character offset.  Insert the data in 
* the middle of the character data. 
* 
* Retrieve the character data from the second child of  
* the first employee.  The "insertData(offset,arg)"
* method is then called with offset=9 and arg="Ann".
* The method should insert the string "Ann" at position 9.
* The new value of the character data should be
* "Margaret Ann Martin".
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-72AB8359">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-72AB8359</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-3EDB695F">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-3EDB695F</a>
*/
class CharacterData_Insert_Data_Middle_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/characterdatainsertdatamiddle")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node nameNode;
  CharacterData child;
  String childData;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("name");
  nameNode = elementList.item(0);
  child = (CharacterData) nameNode.getFirstChild();
  child.insertData(9, "Ann ");
  childData = child.getData();
  assertEquals("Margaret Ann Martin", childData, "characterdataInsertDataMiddleAssert");
 }
}