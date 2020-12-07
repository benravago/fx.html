package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Load a document and invoke its 
* "getImplementation()" method.  This should create a
* DOMImplementation object whose "hasFeature(feature,
* version)" method is invoked with version equal to null.
* If the version is not specified, supporting any version
* feature will cause the method to return "true".
* @author Curt Arnold
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-5CED94D7">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-5CED94D7</a>
* @see <a href="http://www.w3.org/2000/11/DOM-Level-2-errata#core-14">http://www.w3.org/2000/11/DOM-Level-2-errata#core-14</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=245">http://www.w3.org/Bugs/Public/show_bug.cgi?id=245</a>
*/
@Disabled("fx")
class HC_DOMImplementation_Feature_Null_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  feature("hasNullString");
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_domimplementationfeaturenull")
 void run() throws Throwable {
  Document doc;
  DOMImplementation domImpl;
  boolean state;
  doc = (Document) load("hc_staff", false);
  domImpl = doc.getImplementation();
  if (("text/html".equals(getContentType()))) {
   state = domImpl.hasFeature("HTML", null);
   assertTrue(state, "supports_HTML_null");
  } else {
   state = domImpl.hasFeature("XML", null);
   assertTrue(state, "supports_XML_null");
  }
 }
}