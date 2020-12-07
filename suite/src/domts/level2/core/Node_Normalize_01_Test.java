package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method "normalize" puts all Text nodes in the full depth of the sub-tree underneath 
* this Node, including attribute nodes, into a "normal" form where only structure 
* (e.g., elements, comments, processing instructions, CDATA sections, and entity references) 
* separates Text nodes, i.e., there are neither adjacent Text nodes nor empty Text nodes. 
* 
* Create a dom tree consisting of elements, comments, processing instructions, CDATA sections, 
* and entity references nodes seperated by text nodes.  Check the length of the node list of each
* before and after normalize has been called.  
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-normalize">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-normalize</a>
*/
class Node_Normalize_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/nodenormalize01")
 void run() throws Throwable {
  Document doc;
  Document newDoc;
  DOMImplementation domImpl;
  DocumentType docType;
  DocumentType docTypeNull = null;
  Element documentElement;
  Element element1;
  Element element2;
  Element element3;
  Element element4;
  Element element5;
  Element element6;
  Element element7;
  Text text1;
  Text text2;
  Text text3;
  ProcessingInstruction pi;
  CDATASection cData;
  Comment comment;
  EntityReference entRef;
  NodeList elementList;
  Node appendedChild;
  doc = (Document) load("staffNS", true);
  domImpl = doc.getImplementation();
  newDoc = domImpl.createDocument("http://www.w3.org/DOM/Test", "dom:root", docTypeNull);
  element1 = newDoc.createElement("element1");
  element2 = newDoc.createElement("element2");
  element3 = newDoc.createElement("element3");
  element4 = newDoc.createElement("element4");
  element5 = newDoc.createElement("element5");
  element6 = newDoc.createElement("element6");
  element7 = newDoc.createElement("element7");
  text1 = newDoc.createTextNode("text1");
  text2 = newDoc.createTextNode("text2");
  text3 = newDoc.createTextNode("text3");
  cData = newDoc.createCDATASection("Cdata");
  comment = newDoc.createComment("comment");
  pi = newDoc.createProcessingInstruction("PITarget", "PIData");
  entRef = newDoc.createEntityReference("EntRef");
  assertNotNull(entRef, "createdEntRefNotNull");
  documentElement = newDoc.getDocumentElement();
  appendedChild = documentElement.appendChild(element1);
  appendedChild = element2.appendChild(text1);
  appendedChild = element2.appendChild(text2);
  appendedChild = element2.appendChild(text3);
  appendedChild = element1.appendChild(element2);
  text1 = (Text) text1.cloneNode(false);
  text2 = (Text) text2.cloneNode(false);
  appendedChild = element3.appendChild(entRef);
  appendedChild = element3.appendChild(text1);
  appendedChild = element3.appendChild(text2);
  appendedChild = element1.appendChild(element3);
  text1 = (Text) text1.cloneNode(false);
  text2 = (Text) text2.cloneNode(false);
  appendedChild = element4.appendChild(cData);
  appendedChild = element4.appendChild(text1);
  appendedChild = element4.appendChild(text2);
  appendedChild = element1.appendChild(element4);
  text2 = (Text) text2.cloneNode(false);
  text3 = (Text) text3.cloneNode(false);
  appendedChild = element5.appendChild(comment);
  appendedChild = element5.appendChild(text2);
  appendedChild = element5.appendChild(text3);
  appendedChild = element1.appendChild(element5);
  text2 = (Text) text2.cloneNode(false);
  text3 = (Text) text3.cloneNode(false);
  appendedChild = element6.appendChild(pi);
  appendedChild = element6.appendChild(text2);
  appendedChild = element6.appendChild(text3);
  appendedChild = element1.appendChild(element6);
  entRef = (EntityReference) entRef.cloneNode(false);
  text1 = (Text) text1.cloneNode(false);
  text2 = (Text) text2.cloneNode(false);
  text3 = (Text) text3.cloneNode(false);
  appendedChild = element7.appendChild(entRef);
  appendedChild = element7.appendChild(text1);
  appendedChild = element7.appendChild(text2);
  appendedChild = element7.appendChild(text3);
  appendedChild = element1.appendChild(element7);
  elementList = element1.getChildNodes();
  assertTrue(equalsSize(6, elementList), "nodeNormalize01_1Bef");
  elementList = element2.getChildNodes();
  assertTrue(equalsSize(3, elementList), "nodeNormalize01_2Bef");
  elementList = element3.getChildNodes();
  assertTrue(equalsSize(3, elementList), "nodeNormalize01_3Bef");
  elementList = element4.getChildNodes();
  assertTrue(equalsSize(3, elementList), "nodeNormalize01_4Bef");
  elementList = element5.getChildNodes();
  assertTrue(equalsSize(3, elementList), "nodeNormalize01_5Bef");
  elementList = element6.getChildNodes();
  assertTrue(equalsSize(3, elementList), "nodeNormalize01_6Bef");
  elementList = element7.getChildNodes();
  assertTrue(equalsSize(4, elementList), "nodeNormalize01_7Bef");
  newDoc.normalize();
  elementList = element1.getChildNodes();
  assertTrue(equalsSize(6, elementList), "nodeNormalize01_1Aft");
  elementList = element2.getChildNodes();
  assertTrue(equalsSize(1, elementList), "nodeNormalize01_2Aft");
  elementList = element3.getChildNodes();
  assertTrue(equalsSize(2, elementList), "nodeNormalize01_3Aft");
  elementList = element4.getChildNodes();
  assertTrue(equalsSize(2, elementList), "nodeNormalize01_4Aft");
  elementList = element5.getChildNodes();
  assertTrue(equalsSize(2, elementList), "nodeNormalize01_5Aft");
  elementList = element6.getChildNodes();
  assertTrue(equalsSize(2, elementList), "nodeNormalize01_6Aft");
  elementList = element7.getChildNodes();
  assertTrue(equalsSize(2, elementList), "nodeNormalize01_7Aft");
 }
}