package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* On successful invocation of the "deleteData(offset,count)"
* method, the "getData()" and "getLength()" methods reflect
* the changes. 
* 
* Retrieve the character data from the last child of the
* first employee.  The "deleteData(offset,count)"
* method is then called with offset=30 and count=5.
* The method should delete the characters from position
* 30 thru position 35.  The new value of the character data
* should be "1230 North Ave. Dallas, Texas" which is
* returned by the "getData()" method and "getLength()"
* method should return 30".
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-72AB8359">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-72AB8359</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-7D61178C">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-7D61178C</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-7C603781">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-7C603781</a>
*/
class HC_CharacterData_Delete_Data_Get_Length_And_Data_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_characterdatadeletedatagetlengthanddata")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node nameNode;
  CharacterData child;
  String childData;
  int childLength;
  List result = new ArrayList();
  doc = (Document) load("hc_staff", true);
  elementList = doc.getElementsByTagName("acronym");
  nameNode = elementList.item(0);
  child = (CharacterData) nameNode.getFirstChild();
  child.deleteData(30, 5);
  childData = child.getData();
  assertEquals("1230 North Ave. Dallas, Texas ", childData, "data");
  childLength = (int) child.getLength();
  assertEquals(30, childLength, "length");
 }
}