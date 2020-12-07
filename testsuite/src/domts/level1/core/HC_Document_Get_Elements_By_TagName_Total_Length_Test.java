package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Retrieve the entire DOM document and invoke its 
* "getElementsByTagName(tagName)" method with tagName
* equal to "*".  The method should return a NodeList 
* that contains all the elements of the document. 
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-A6C9094">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-A6C9094</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=251">http://www.w3.org/Bugs/Public/show_bug.cgi?id=251</a>
*/
@Disabled("fx")
class HC_Document_Get_Elements_By_TagName_Total_Length_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_documentgetelementsbytagnametotallength")
 void run() throws Throwable {
  Document doc;
  NodeList nameList;
  List expectedNames = new ArrayList();
  expectedNames.add("html");
  expectedNames.add("head");
  expectedNames.add("meta");
  expectedNames.add("title");
  expectedNames.add("script");
  expectedNames.add("script");
  expectedNames.add("script");
  expectedNames.add("body");
  expectedNames.add("p");
  expectedNames.add("em");
  expectedNames.add("strong");
  expectedNames.add("code");
  expectedNames.add("sup");
  expectedNames.add("var");
  expectedNames.add("acronym");
  expectedNames.add("p");
  expectedNames.add("em");
  expectedNames.add("strong");
  expectedNames.add("code");
  expectedNames.add("sup");
  expectedNames.add("var");
  expectedNames.add("acronym");
  expectedNames.add("p");
  expectedNames.add("em");
  expectedNames.add("strong");
  expectedNames.add("code");
  expectedNames.add("sup");
  expectedNames.add("var");
  expectedNames.add("acronym");
  expectedNames.add("p");
  expectedNames.add("em");
  expectedNames.add("strong");
  expectedNames.add("code");
  expectedNames.add("sup");
  expectedNames.add("var");
  expectedNames.add("acronym");
  expectedNames.add("p");
  expectedNames.add("em");
  expectedNames.add("strong");
  expectedNames.add("code");
  expectedNames.add("sup");
  expectedNames.add("var");
  expectedNames.add("acronym");
  List svgExpectedNames = new ArrayList();
  svgExpectedNames.add("svg");
  svgExpectedNames.add("rect");
  svgExpectedNames.add("script");
  svgExpectedNames.add("head");
  svgExpectedNames.add("meta");
  svgExpectedNames.add("title");
  svgExpectedNames.add("body");
  svgExpectedNames.add("p");
  svgExpectedNames.add("em");
  svgExpectedNames.add("strong");
  svgExpectedNames.add("code");
  svgExpectedNames.add("sup");
  svgExpectedNames.add("var");
  svgExpectedNames.add("acronym");
  svgExpectedNames.add("p");
  svgExpectedNames.add("em");
  svgExpectedNames.add("strong");
  svgExpectedNames.add("code");
  svgExpectedNames.add("sup");
  svgExpectedNames.add("var");
  svgExpectedNames.add("acronym");
  svgExpectedNames.add("p");
  svgExpectedNames.add("em");
  svgExpectedNames.add("strong");
  svgExpectedNames.add("code");
  svgExpectedNames.add("sup");
  svgExpectedNames.add("var");
  svgExpectedNames.add("acronym");
  svgExpectedNames.add("p");
  svgExpectedNames.add("em");
  svgExpectedNames.add("strong");
  svgExpectedNames.add("code");
  svgExpectedNames.add("sup");
  svgExpectedNames.add("var");
  svgExpectedNames.add("acronym");
  svgExpectedNames.add("p");
  svgExpectedNames.add("em");
  svgExpectedNames.add("strong");
  svgExpectedNames.add("code");
  svgExpectedNames.add("sup");
  svgExpectedNames.add("var");
  svgExpectedNames.add("acronym");
  List actualNames = new ArrayList();
  Element thisElement;
  String thisTag;
  doc = (Document) load("hc_staff", false);
  nameList = doc.getElementsByTagName("*");
  for (int indexN10148 = 0; indexN10148 < nameList.getLength(); indexN10148++) {
   thisElement = (Element) nameList.item(indexN10148);
   thisTag = thisElement.getTagName();
   actualNames.add(thisTag);
  }
  if (("image/svg+xml".equals(getContentType()))) {
   assertTrue(equalsAutoCase("element", svgExpectedNames, actualNames), "svgTagNames");
  } else {
   assertTrue(equalsAutoCase("element", expectedNames, actualNames), "tagNames");
  }
 }
}