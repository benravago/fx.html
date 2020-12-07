package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method setPrefix raises a NAMESPACE_ERR if the specified prefix is malformed.
* Create a new namespace aware element node and call the setPrefix method on it with several malformed
* prefix values.  Check if a NAMESPACE_ERR is thrown.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix</a>
*/
class Node_Set_Prefix_05_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/nodesetprefix05")
 void run() throws Throwable {
  Document doc;
  Element element;
  String prefixValue;
  List prefixValues = new ArrayList();
  prefixValues.add("_:");
  prefixValues.add(":0");
  prefixValues.add(":");
  prefixValues.add("_::");
  prefixValues.add("a:0:c");
  doc = (Document) load("staffNS", true);
  element = doc.createElementNS("http://www.w3.org/DOM/Test/L2", "dom:elem");
  for (int indexN10050 = 0; indexN10050 < prefixValues.size(); indexN10050++) {
   prefixValue = (String) prefixValues.get(indexN10050);
   {
    boolean success = false;
    try {
     element.setPrefix(prefixValue);
    } catch (DOMException ex) {
     success = (ex.code == DOMException.NAMESPACE_ERR);
    }
    assertTrue(success, "throw_NAMESPACE_ERR");
   }
  }
 }
}