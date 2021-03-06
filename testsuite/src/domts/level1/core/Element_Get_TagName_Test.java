package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getTagName()" method returns the 
* tagName of an element.    
* 
* Invoke the "getTagName()" method one the 
* root node. The value returned should be "staff". 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-104682815">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-104682815</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=251">http://www.w3.org/Bugs/Public/show_bug.cgi?id=251</a>
*/
class Element_Get_TagName_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/elementgettagname")
 void run() throws Throwable {
  Document doc;
  Element root;
  String tagname;
  doc = (Document) load("staff", false);
  root = doc.getDocumentElement();
  tagname = root.getTagName();
  if (("image/svg+xml".equals(getContentType()))) {
   assertEquals("svg", tagname, "svgTagName");
  } else {
   assertEquals("staff", tagname, "elementGetTagNameAssert");
  }
 }
}