package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "replaceData(offset,count,arg)" method replaces the
* characters starting at the specified offset with the
* specified string.  Test for replacement in the
* middle of the data.
* Retrieve the character data from the last child of the
* first employee.  The "replaceData(offset,count,arg)"
* method is then called with offset=5 and count=5 and
* arg="South".  The method should replace characters five
* thru 9 of the character data with "South".
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-E5CBA7FB">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-E5CBA7FB</a>
*/
class CharacterData_Replace_Data_Beginning_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/characterdatareplacedatabegining")
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
  child.replaceData(0, 4, "2500");
  childData = child.getData();
  assertEquals("2500 North Ave. Dallas, Texas 98551", childData, "characterdataReplaceDataBeginingAssert");
 }
}