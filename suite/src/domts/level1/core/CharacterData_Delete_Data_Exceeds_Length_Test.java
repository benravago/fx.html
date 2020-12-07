package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* If the sum of the offset and count used in the        
* "deleteData(offset,count) method is greater than the
* length of the character data then all the characters
* from the offset to the end of the data are deleted. 
* 
* Retrieve the character data from the last child of the
* first employee.  The "deleteData(offset,count)"
* method is then called with offset=4 and count=50.
* The method should delete the characters from position 4
* to the end of the data since the offset+count(50+4)
* is greater than the length of the character data(35).
* The new value of the character data should be "1230".
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-72AB8359">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-72AB8359</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-7C603781">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-7C603781</a>
*/
class CharacterData_Delete_Data_Exceeds_Length_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/characterdatadeletedataexceedslength")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node nameNode;
  CharacterData child;
  String childData;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("address");
  nameNode = elementList.item(0);
  child = (CharacterData) nameNode.getFirstChild();
  child.deleteData(4, 50);
  childData = child.getData();
  assertEquals("1230", childData, "characterdataDeleteDataExceedsLengthAssert");
 }
}