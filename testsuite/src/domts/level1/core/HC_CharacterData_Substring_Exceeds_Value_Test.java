package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* If the sum of the "offset" and "count" exceeds the
* "length" then the "substringData(offset,count)" method
* returns all the characters to the end of the data. 
* 
* Retrieve the character data from the second child 
* of the first employee and access part of the data 
* by using the substringData(offset,count) method
* with offset=9 and count=10.  The method should return 
* the substring "Martin" since offset+count > length
* (19 > 15).
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-6531BCCF">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-6531BCCF</a>
*/
class HC_CharacterData_Substring_Exceeds_Value_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_characterdatasubstringexceedsvalue")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node nameNode;
  CharacterData child;
  String substring;
  doc = (Document) load("hc_staff", false);
  elementList = doc.getElementsByTagName("strong");
  nameNode = elementList.item(0);
  child = (CharacterData) nameNode.getFirstChild();
  substring = child.substringData(9, 10);
  assertEquals("Martin", substring, "characterdataSubStringExceedsValueAssert");
 }
}