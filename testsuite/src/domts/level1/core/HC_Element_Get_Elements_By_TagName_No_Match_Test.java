package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getElementsByTagName(name)" method returns a list
* of all descendant Elements with the given tag name.
* Create a NodeList of all the descendant elements
* using the string "employee" as the tagName.
* The method should return a NodeList whose length is
* "5".
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1938918D">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1938918D</a>
*/
class HC_Element_Get_Elements_By_TagName_No_Match_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_elementgetelementsbytagnamenomatch")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  doc = (Document) load("hc_staff", false);
  elementList = doc.getElementsByTagName("noMatch");
  assertTrue(equalsSize(0, elementList), "elementGetElementsByTagNameNoMatchNoMatchAssert");
 }
}