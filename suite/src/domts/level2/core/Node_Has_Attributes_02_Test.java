package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method hasAttributes returns whether this node (if it is an element) has any attributes.
* Retrieve the docType node.  Since this is not an element node check if hasAttributes returns
* null.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeHasAttrs">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeHasAttrs</a>
*/
class Node_Has_Attributes_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/nodehasattributes02")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  boolean hasAttributes;
  doc = (Document) load("staffNS", false);
  docType = doc.getDoctype();
  hasAttributes = docType.hasAttributes();
  assertFalse(hasAttributes, "nodehasattributes02");
 }
}