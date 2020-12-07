package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* If the sum of the offset and count exceeds the length then 
* all the characters to the end of the data are replaced.
* 
* Retrieve the character data from the last child of the
* first employee.  The "replaceData(offset,count,arg)"
* method is then called with offset=0 and count=50 and
* arg="2600".  The method should replace all the characters
* with "2600". This is because the sum of the offset and
* count exceeds the length of the character data.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-72AB8359">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-72AB8359</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-E5CBA7FB">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-E5CBA7FB</a>
*/
class HC_CharacterData_Replace_Data_Exceeds_Length_Of_Data_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_characterdatareplacedataexceedslengthofdata")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node nameNode;
  CharacterData child;
  String childData;
  doc = (Document) load("hc_staff", true);
  elementList = doc.getElementsByTagName("acronym");
  nameNode = elementList.item(0);
  child = (CharacterData) nameNode.getFirstChild();
  child.replaceData(0, 50, "2600");
  childData = child.getData();
  assertEquals("2600", childData, "characterdataReplaceDataExceedsLengthOfDataAssert");
 }
}