package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "substringData(offset,count)" method returns the 
* specified string.
* 
* Retrieve the character data from the second child 
* of the first employee and access part of the data 
* by using the substringData(offset,count) method.  The
* method should return the specified substring starting 
* at position "offset" and extract "count" characters.
* The method should return the string "Margaret".
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-6531BCCF">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-6531BCCF</a>
*/
class HC_CharacterData_Substring_Value_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_characterdatasubstringvalue")
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
  substring = child.substringData(0, 8);
  assertEquals("Margaret", substring, "characterdataSubStringValueAssert");
 }
}