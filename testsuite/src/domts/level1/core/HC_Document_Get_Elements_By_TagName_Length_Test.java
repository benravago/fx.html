package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getElementsByTagName(tagName)" method returns a 
* NodeList of all the Elements with a given tagName.
* 
* Retrieve the entire DOM document and invoke its 
* "getElementsByTagName(tagName)" method with tagName
* equal to "strong".  The method should return a NodeList 
* that contains 5 elements.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-A6C9094">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-A6C9094</a>
*/
class HC_Document_Get_Elements_By_TagName_Length_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_documentgetelementsbytagnamelength")
 void run() throws Throwable {
  Document doc;
  NodeList nameList;
  doc = (Document) load("hc_staff", false);
  nameList = doc.getElementsByTagName("strong");
  assertTrue(equalsSize(5, nameList), "documentGetElementsByTagNameLengthAssert");
 }
}