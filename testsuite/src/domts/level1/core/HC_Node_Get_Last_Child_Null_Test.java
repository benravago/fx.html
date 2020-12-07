package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* If there is not a last child then the "getLastChild()"
* method returns null.
* Retrieve the text of the first "em" element and invoke the "getFirstChild()" method.   It
* should return null.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-61AD09FB">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-61AD09FB</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=246">http://www.w3.org/Bugs/Public/show_bug.cgi?id=246</a>
*/
class HC_Node_Get_Last_Child_Null_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodegetlastchildnull")
 void run() throws Throwable {
  Document doc;
  NodeList emList;
  Node emNode;
  CharacterData emText;
  Node nullChild;
  doc = (Document) load("hc_staff", false);
  emList = doc.getElementsByTagName("em");
  emNode = emList.item(0);
  emText = (CharacterData) emNode.getFirstChild();
  nullChild = emText.getLastChild();
  assertNull(nullChild, "nullChild");
 }
}