package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* hasFeature("xml", "1.0") should return true for implementations that can read staff documents.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-5CED94D7">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-5CED94D7</a>
*/
@Disabled("fx")
class DOMImplementation_Feature_XML_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/domimplementationfeaturexml")
 void run() throws Throwable {
  Document doc;
  DOMImplementation domImpl;
  boolean state;
  doc = (Document) load("staff", false);
  domImpl = doc.getImplementation();
  state = domImpl.hasFeature("xml", "1.0");
  assertTrue(state, "hasXML1");
 }
}