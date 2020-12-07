package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method "isSupported(feature,version)" Tests whether the DOM implementation 
* implements a specific feature and that feature is supported by this node. 
* 
* Call the isSupported method on the document element node with a combination of features 
* versions and versions as below.  Valid feature names are case insensitive and versions
* "2.0", "1.0" and if the version is not specified, supporting any version of the feature
* should return true.  Check if the value returned value was true.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-Node-supports">http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-Node-supports</a>
*/
class Node_Is_Supported_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/nodeissupported01")
 void run() throws Throwable {
  Document doc;
  Element element;
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
  element = doc.getDocumentElement();
  for (int indexN10063 = 0; indexN10063 < featuresXML.size(); indexN10063++) {
   featureXML = (String) featuresXML.get(indexN10063);
   success = element.isSupported(featureXML, version);
   assertTrue(success, "nodeissupported01_XML1");
   success = element.isSupported(featureXML, version1);
   assertTrue(success, "nodeissupported01_XML2");
  }
  for (int indexN1007C = 0; indexN1007C < featuresCore.size(); indexN1007C++) {
   featureCore = (String) featuresCore.get(indexN1007C);
   success = element.isSupported(featureCore, version);
   assertTrue(success, "nodeissupported01_Core1");
   success = element.isSupported(featureCore, version1);
   success = element.isSupported(featureCore, version2);
   assertTrue(success, "nodeissupported01_Core3");
  }
 }
}