package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Retrieve the entire DOM document and invoke its 
* "getImplementation()" method.  This should create a
* DOMImplementation object whose "hasFeature(feature,
* version)" method is invoked with "feature" equal to "html" or "xml".
* The method should return a boolean "true".
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-5CED94D7">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-5CED94D7</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=245">http://www.w3.org/Bugs/Public/show_bug.cgi?id=245</a>
*/
@Disabled("fx")
class HC_DOMImplementation_Feature_XML_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_domimplementationfeaturexml")
 void run() throws Throwable {
  Document doc;
  DOMImplementation domImpl;
  boolean state;
  doc = (Document) load("hc_staff", false);
  domImpl = doc.getImplementation();
  if (("text/html".equals(getContentType()))) {
   state = domImpl.hasFeature("html", "1.0");
   assertTrue(state, "supports_html_1.0");
  } else {
   state = domImpl.hasFeature("xml", "1.0");
   assertTrue(state, "supports_xml_1.0");
  }
 }
}