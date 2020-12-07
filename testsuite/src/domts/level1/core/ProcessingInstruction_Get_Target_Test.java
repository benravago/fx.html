package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getTarget()" method returns the target of the  
* processing instruction.  It is the first token following
* the markup that begins the processing instruction.
* 
* Retrieve the ProcessingInstruction node located  
* immediately after the prolog.  Create a nodelist of the 
* child nodes of this document.  Invoke the "getTarget()"
* method on the first child in the list. This should
* return the target of the ProcessingInstruction.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1478689192">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1478689192</a>
*/
class ProcessingInstruction_Get_Target_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/processinginstructiongettarget")
 void run() throws Throwable {
  Document doc;
  NodeList childNodes;
  ProcessingInstruction piNode;
  String target;
  doc = (Document) load("staff", false);
  childNodes = doc.getChildNodes();
  piNode = (ProcessingInstruction) childNodes.item(0);
  target = piNode.getTarget();
  assertEquals("TEST-STYLE", target, "processinginstructionGetTargetAssert");
 }
}