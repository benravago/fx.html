package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getImplementation()" method returns the 
* DOMImplementation object that handles this document. 
* Retrieve the entire DOM document and invoke its 
* "getImplementation()" method.  It should return a 
* DOMImplementation whose "hasFeature("XML","1.0")
* method returns the boolean value "true".
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1B793EBA">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1B793EBA</a>
*/
@Disabled("fx")
class Document_Get_Implementation_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/documentgetimplementation")
 void run() throws Throwable {
  Document doc;
  DOMImplementation docImpl;
  boolean state;
  doc = (Document) load("staff", false);
  docImpl = doc.getImplementation();
  state = docImpl.hasFeature("XML", "1.0");
  assertTrue(state, "documentGetImplementationAssert");
 }
}