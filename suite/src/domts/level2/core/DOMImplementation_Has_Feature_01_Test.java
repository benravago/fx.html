package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method "hasFeature(feature,version)" tests if the DOMImplementation implements
* a specific feature and if so returns true.
* 
* Call the hasFeature method on this DOMImplementation with a combination of features 
* versions as below.  Valid feature names are case insensitive and versions "2.0", 
* "1.0" and if the version is not specified, supporting any version of the feature
* should return true.  Check if the value returned value was true.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-5CED94D7">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-5CED94D7</a>
*/
class DOMImplementation_Has_Feature_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/domimplementationhasfeature01")
 void run() throws Throwable {
  Document doc;
  DOMImplementation domImpl;
  String version = "";
  String version1 = "1.0";
  String version2 = "2.0";
  String featureCore;
  String featureXML;
  boolean success;
  List featuresXML = new ArrayList();
  featuresXML.add("XML");
  featuresXML.add("xmL");
  List featuresCore = new ArrayList();
  featuresCore.add("Core");
  featuresCore.add("CORE");
  doc = (Document) load("staffNS", false);
  domImpl = doc.getImplementation();
  for (int indexN10063 = 0; indexN10063 < featuresXML.size(); indexN10063++) {
   featureXML = (String) featuresXML.get(indexN10063);
   success = domImpl.hasFeature(featureXML, version);
   assertTrue(success, "domimplementationhasfeature01_XML_1");
   success = domImpl.hasFeature(featureXML, version1);
   assertTrue(success, "domimplementationhasfeature01_XML_2");
  }
  for (int indexN1007C = 0; indexN1007C < featuresCore.size(); indexN1007C++) {
   featureCore = (String) featuresCore.get(indexN1007C);
   success = domImpl.hasFeature(featureCore, version);
   assertTrue(success, "domimplementationhasfeature01_Core_1");
   success = domImpl.hasFeature(featureCore, version1);
   success = domImpl.hasFeature(featureCore, version2);
   assertTrue(success, "domimplementationhasfeature01_Core_3");
  }
 }
}