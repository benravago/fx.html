package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "deleteData(offset,count)" method removes a range of
* characters from the node.  Delete data at the beginning
* of the character data.
* Retrieve the character data from the last child of the
* first employee.  The "deleteData(offset,count)"
* method is then called with offset=0 and count=16.
* The method should delete the characters from position
* 0 thru position 16.  The new value of the character data
* should be "Dallas, Texas 98551".
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-7C603781">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-7C603781</a>
*/
class CharacterData_Delete_Data_Beginning_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/characterdatadeletedatabegining")
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
  child.deleteData(0, 16);
  childData = child.getData();
  assertEquals("Dallas, Texas 98551", childData, "characterdataDeleteDataBeginingAssert");
 }
}