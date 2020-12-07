package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Retrieve the entire DOM document, invoke
* getElementsByTagName("*") and check the length of the NodeList. 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-A6C9094">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-A6C9094</a>
*/
@Disabled("fx")
class Document_Get_Elements_By_TagName_Total_Length_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/documentgetelementsbytagnametotallength")
 void run() throws Throwable {
  Document doc;
  NodeList nameList;
  doc = (Document) load("staff", false);
  nameList = doc.getElementsByTagName("*");
  if (("image/svg+xml".equals(getContentType()))) {
   assertTrue(equalsSize(39, nameList), "elementCountSVG");
  } else {
   assertTrue(equalsSize(37, nameList), "documentGetElementsByTagNameTotalLengthAssert");
  }
 }
}