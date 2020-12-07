package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Retrieve the entire DOM document and invoke its 
* "getImplementation()" method.  If contentType="text/html", 
* DOMImplementation.hasFeature("HTML","1.0") should be true.  
* Otherwise, DOMImplementation.hasFeature("XML", "1.0")
* should be true.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1B793EBA">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1B793EBA</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=245">http://www.w3.org/Bugs/Public/show_bug.cgi?id=245</a>
*/
@Disabled("fx")
class HC_Document_Get_Implementation_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_documentgetimplementation")
 void run() throws Throwable {
  Document doc;
  DOMImplementation docImpl;
  boolean xmlstate;
  boolean htmlstate;
  doc = (Document) load("hc_staff", false);
  docImpl = doc.getImplementation();
  xmlstate = docImpl.hasFeature("XML", "1.0");
  htmlstate = docImpl.hasFeature("HTML", "1.0");
  if (("text/html".equals(getContentType()))) {
   assertTrue(htmlstate, "supports_HTML_1.0");
  } else {
   assertTrue(xmlstate, "supports_XML_1.0");
  }
 }
}