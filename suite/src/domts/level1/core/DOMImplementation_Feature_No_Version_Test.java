package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* hasFeature("XML", "") should return true for implementations that can read staff files.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-5CED94D7">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-5CED94D7</a>
* @see <a href="http://www.w3.org/2000/11/DOM-Level-2-errata#core-14">http://www.w3.org/2000/11/DOM-Level-2-errata#core-14</a>
*/
@Disabled("fx")
class DOMImplementation_Feature_No_Version_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/domimplementationfeaturenoversion")
 void run() throws Throwable {
  Document doc;
  DOMImplementation domImpl;
  boolean state;
  doc = (Document) load("staff", false);
  domImpl = doc.getImplementation();
  state = domImpl.hasFeature("XML", "");
  assertTrue(state, "hasXMLEmpty");
 }
}