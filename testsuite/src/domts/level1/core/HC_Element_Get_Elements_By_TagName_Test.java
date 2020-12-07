package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getElementsByTagName(name)" method returns a list
* of all descendant Elements with the given tag name.
* Test for an empty list.
* Create a NodeList of all the descendant elements
* using the string "noMatch" as the tagName.
* The method should return a NodeList whose length is
* "0" since there are not any descendant elements
* that match the given tag name.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1938918D">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1938918D</a>
*/
class HC_Element_Get_Elements_By_TagName_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_elementgetelementsbytagname")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  doc = (Document) load("hc_staff", false);
  elementList = doc.getElementsByTagName("p");
  assertTrue(equalsSize(5, elementList), "elementGetElementsByTagNameAssert");
 }
}