package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "createProcessingInstruction(target,data)" method 
* creates a new ProcessingInstruction node with the
* specified name and data string.
* 
* Retrieve the entire DOM document and invoke its 
* "createProcessingInstruction(target,data)" method.  
* It should create a new PI node with the specified target 
* and data.  The target, data and type are retrieved and
* output.
* @author NIST
* @author Mary Brady
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#</a>
* @see <a href="http://lists.w3.org/Archives/Public/www-dom-ts/2001Apr/0020.html">http://lists.w3.org/Archives/Public/www-dom-ts/2001Apr/0020.html</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-135944439">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-135944439</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=249">http://www.w3.org/Bugs/Public/show_bug.cgi?id=249</a>
*/
class Document_Create_ProcessingInstruction_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/documentcreateprocessinginstruction")
 void run() throws Throwable {
  Document doc;
  ProcessingInstruction newPINode;
  String piValue;
  String piName;
  int piType;
  doc = (Document) load("staff", true);
  newPINode = doc.createProcessingInstruction("TESTPI", "This is a new PI node");
  assertNotNull(newPINode, "createdPINotNull");
  piName = newPINode.getNodeName();
  assertEquals("TESTPI", piName, "name");
  piValue = newPINode.getNodeValue();
  assertEquals("This is a new PI node", piValue, "value");
  piType = (int) newPINode.getNodeType();
  assertEquals(7, piType, "type");
 }
}