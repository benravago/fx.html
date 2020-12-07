package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "replaceData(offset,count,arg)" method replaces the 
* characters starting at the specified offset with the
* specified string.  Test for replacement at the 
* end of the data.
* 
* Retrieve the character data from the last child of the
* first employee.  The "replaceData(offset,count,arg)"
* method is then called with offset=30 and count=5 and
* arg="98665".  The method should replace characters 30  
* thru 34 of the character data with "98665".
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-72AB8359">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-72AB8359</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-E5CBA7FB">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-E5CBA7FB</a>
*/
class HC_CharacterData_Replace_Data_End_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_characterdatareplacedataend")
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
  child.replaceData(30, 5, "98665");
  childData = child.getData();
  assertEquals("1230 North Ave. Dallas, Texas 98665", childData, "characterdataReplaceDataEndAssert");
 }
}