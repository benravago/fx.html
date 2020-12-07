package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Adjacent CDATASection nodes cannot be merged together by
* use of the "normalize()" method from the Element interface.
* Retrieve second child of the second employee and invoke
* the "normalize()" method.  The Element under contains
* two CDATASection nodes that should not be merged together
* by the "normalize()" method.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-162CF083">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-162CF083</a>
*/
@Disabled("fx")
class CDATASection_Normalize_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/cdatasectionnormalize")
 void run() throws Throwable {
  Document doc;
  NodeList nameList;
  Element lChild;
  NodeList childNodes;
  CDATASection cdataN;
  String data;
  doc = (Document) load("staff", true);
  nameList = doc.getElementsByTagName("name");
  lChild = (Element) nameList.item(1);
  lChild.normalize();
  childNodes = lChild.getChildNodes();
  cdataN = (CDATASection) childNodes.item(1);
  assertNotNull(cdataN, "firstCDATASection");
  data = cdataN.getData();
  assertEquals("This is a CDATASection with EntityReference number 2 &ent2;", data, "data1");
  cdataN = (CDATASection) childNodes.item(3);
  assertNotNull(cdataN, "secondCDATASection");
  data = cdataN.getData();
  assertEquals("This is an adjacent CDATASection with a reference to a tab &tab;", data, "data3");
 }
}