package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* An processing instruction is created, setNodeValue is called with a non-null argument, but getNodeValue
* should still return null.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D080">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D080</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1004215813">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1004215813</a>
*/
class Node_Value_09_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodevalue09")
 void run() throws Throwable {
  Document doc;
  Node newNode;
  String newValue;
  doc = (Document) load("staff", true);
  newNode = doc.createProcessingInstruction("TARGET", "DATA");
  newValue = newNode.getNodeValue();
  assertEquals("DATA", newValue, "initial");
  newNode.setNodeValue("This should have an effect");
  newValue = newNode.getNodeValue();
  assertEquals("This should have an effect", newValue, "after");
 }
}