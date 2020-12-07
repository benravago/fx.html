package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* On successful invocation of the "appendData(arg)" 
* method the "getData()" method provides access to the
* concatentation of data and the specified string.
* 
* Retrieve the character data from the second child 
* of the first employee.  The appendData(arg) method is
* called with arg=", Esquire".  The method should append 
* the specified data to the already existing character  
* data.  The new value return by the "getData()" method
* should be "Margaret Martin, Esquire".
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-72AB8359">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-72AB8359</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-32791A2F">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-32791A2F</a>
*/
class HC_CharacterData_Append_Data_Get_Data_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_characterdataappenddatagetdata")
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
  child.appendData(", Esquire");
  childData = child.getData();
  assertEquals("Margaret Martin, Esquire", childData, "characterdataAppendDataGetDataAssert");
 }
}