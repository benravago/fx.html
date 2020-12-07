package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "feature" parameter in the
* "hasFeature(feature,version)" method is the package name
* of the feature.  Legal values are XML and HTML.
* (Test for feature "xml" and version "2.0") 
* 
* Retrieve the entire DOM document and invoke its 
* "getImplementation()" method.  This should create a
* DOMImplementation object whose "hasFeature(feature,
* version)" method is invoked with "feature" equal to "xml".
* The method should return a boolean "true".
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-5CED94D7">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-5CED94D7</a>
*/
class DOMImplementation_Feature_XML_Version2_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/domimplementationfeaturexmlversion2")
 void run() throws Throwable {
  Document doc;
  DOMImplementation domImpl;
  boolean state;
  doc = (Document) load("staff", false);
  domImpl = doc.getImplementation();
  state = domImpl.hasFeature("xml", "2.0");
  assertTrue(state, "domimplementationFeaturexmlVersion2Assert");
 }
}