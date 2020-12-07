package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method getElementsByTagNameNS returns a NodeList of all the Elements with 
* a given local name and namespace URI in the order in which they are encountered 
* in a preorder traversal of the Document tree.
* 
* Invoke the getElementsByTagNameNS method on a new Document object with the values of
* namespaceURI=* and localName=*.  This should return a nodeList of 1 item.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core">http://www.w3.org/TR/DOM-Level-2-Core/core</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getElBTNNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getElBTNNS</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=259">http://www.w3.org/Bugs/Public/show_bug.cgi?id=259</a>
*/
class Document_Get_Elements_By_TagName_NS_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/documentgetelementsbytagnameNS01")
 void run() throws Throwable {
  Document doc;
  Document newDoc;
  DocumentType docType = null;
  DOMImplementation domImpl;
  NodeList childList;
  String nullNS = null;
  doc = (Document) load("staffNS", false);
  domImpl = doc.getImplementation();
  newDoc = domImpl.createDocument(nullNS, "root", docType);
  childList = newDoc.getElementsByTagNameNS("*", "*");
  assertTrue(equalsSize(1, childList), "documentgetelementsbytagnameNS01");
 }
}