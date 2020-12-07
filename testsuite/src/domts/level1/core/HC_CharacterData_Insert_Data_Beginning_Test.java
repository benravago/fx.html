package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "insertData(offset,arg)" method will insert a string
* at the specified character offset.  Insert the data at
* the beginning of the character data.
* Retrieve the character data from the second child of
* the first employee.  The "insertData(offset,arg)"
* method is then called with offset=0 and arg="Mss.".
* The method should insert the string "Mss." at position 0.
* The new value of the character data should be
* "Mss. Margaret Martin".
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-3EDB695F">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-3EDB695F</a>
*/
class HC_CharacterData_Insert_Data_Beginning_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_characterdatainsertdatabeginning")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node nameNode;
  CharacterData child;
  String childData;
  doc = (Document) load("hc_staff", true);
  elementList = doc.getElementsByTagName("strong");
  nameNode = elementList.item(0);
  child = (CharacterData) nameNode.getFirstChild();
  child.insertData(0, "Mss. ");
  childData = child.getData();
  assertEquals("Mss. Margaret Martin", childData, "characterdataInsertDataBeginningAssert");
 }
}