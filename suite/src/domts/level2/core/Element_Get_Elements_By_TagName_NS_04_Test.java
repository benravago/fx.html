package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Returns a NodeList of all the Elements with a given local name and namespace URI in the 
* order in which they are encountered in a preorder traversal of the Document tree. 
* Create a new element node ('root') and append three newly created child nodes (all have 
* local name 'child' and defined in different namespaces). 
* Test 1: invoke getElementsByTagNameNS to retrieve one of the children.
* Test 2: invoke getElementsByTagNameNS with the value of namespace equals to '*', and 
* verify that the node list has length of 3. 
* 
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getElBTNNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getElBTNNS</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=259">http://www.w3.org/Bugs/Public/show_bug.cgi?id=259</a>
*/
class Element_Get_Elements_By_TagName_NS_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/elementgetelementsbytagnamens04")
 void run() throws Throwable {
  Document doc;
  Element element;
  Element child1;
  Element child2;
  Element child3;
  Node appendedChild;
  NodeList elementList;
  String nullNS = null;
  doc = (Document) load("staffNS", false);
  element = doc.createElementNS("http://www.w3.org/DOM", "root");
  child1 = doc.createElementNS("http://www.w3.org/DOM/Level1", "dom:child");
  child2 = doc.createElementNS(nullNS, "child");
  child3 = doc.createElementNS("http://www.w3.org/DOM/Level2", "dom:child");
  appendedChild = element.appendChild(child1);
  appendedChild = element.appendChild(child2);
  appendedChild = element.appendChild(child3);
  elementList = element.getElementsByTagNameNS(nullNS, "child");
  assertTrue(equalsSize(1, elementList), "elementgetelementsbytagnamens04_1");
  elementList = element.getElementsByTagNameNS("*", "child");
  assertTrue(equalsSize(3, elementList), "elementgetelementsbytagnamens04_2");
 }
}