package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The createDocument method with valid arguments, should create a DOM Document of 
* the specified type.  
* 
* Call the createDocument on this DOMImplementation with 
* createDocument ("http://www.w3.org/DOMTest/L2",see the array below for valid QNames,null).  
* Check if the returned Document object is is empty with no Document Element. 
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-DOM-createDocument">http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-DOM-createDocument</a>
*/
class DOMImplementation_Create_Document_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/domimplementationcreatedocument03")
 void run() throws Throwable {
  Document doc;
  DOMImplementation domImpl;
  Document newDoc;
  DocumentType docType = null;
  String namespaceURI = "http://www.w3.org/DOMTest/L2";
  String qualifiedName;
  List qualifiedNames = new ArrayList();
  qualifiedNames.add("_:_");
  qualifiedNames.add("_:h0");
  qualifiedNames.add("_:test");
  qualifiedNames.add("l_:_");
  qualifiedNames.add("ns:_0");
  qualifiedNames.add("ns:a0");
  qualifiedNames.add("ns0:test");
  qualifiedNames.add("a.b:c");
  qualifiedNames.add("a-b:c");
  qualifiedNames.add("a-b:c");
  doc = (Document) load("staffNS", false);
  domImpl = doc.getImplementation();
  for (int indexN1006B = 0; indexN1006B < qualifiedNames.size(); indexN1006B++) {
   qualifiedName = (String) qualifiedNames.get(indexN1006B);
   newDoc = domImpl.createDocument(namespaceURI, qualifiedName, docType);
   assertNotNull(newDoc, "domimplementationcreatedocument03");
  }
 }
}