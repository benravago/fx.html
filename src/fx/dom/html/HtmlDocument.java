package fx.dom.html;

import java.util.function.Predicate;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.html.HTMLCollection;
import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLElement;
import org.w3c.dom.html.HTMLAnchorElement;
import org.w3c.dom.html.HTMLAppletElement;
import org.w3c.dom.html.HTMLAreaElement;
import org.w3c.dom.html.HTMLFormElement;
import org.w3c.dom.html.HTMLImageElement;
import org.w3c.dom.html.HTMLObjectElement;

import fx.dom.core.XmlDocument;
import fx.dom.core.XmlNodeList;

public class HtmlDocument extends XmlDocument implements HTMLDocument {

  protected HtmlDocument() { super(null); }

  @Override public String getCookie() { return null; }
  @Override public void setCookie(String cookie) {}

  @Override public String getReferrer() { return null; }
  @Override public String getDomain() { return null; }
  @Override public String getURL() { return null; }

  @Override
  public Element createElement(String tagName) throws DOMException {
    return Elements.create(tagName,this);
  }

  // Returns the (possibly empty) collection of elements whose name value is given by elementName .
  @Override
  public NodeList getElementsByName(String elementName) {
    var body = (HtmlBodyElement) getBody();
    if (body != null) {
      var list = Content.collect(body.getChildNodes(), n -> n.getNodeName().equals(elementName));
      if (!list.isEmpty()) return XmlNodeList.of(list);
    }
    return XmlNodeList.EMPTY;
  }

  HTMLCollection elements(Predicate<Node> pick) {
    var body = (HtmlBodyElement) getBody();
    return body == null ? HtmlCollection.EMPTY :
      HtmlCollection.of(body.getChildNodes(), pick) ;
  }

  // A collection of all the forms of a document.
  @Override
  public HTMLCollection getForms() {
    return elements(n -> n instanceof HTMLFormElement);
  }

  // A collection of all the IMG elements in a document.
  @Override
  public HTMLCollection getImages() {
    return elements(n -> n instanceof HTMLImageElement);
  }

  // A collection of all the OBJECT elements that include applets and APPLET (deprecated) elements in a document.
  @Override
  public HTMLCollection getApplets() {
    return elements(n -> n instanceof HTMLAppletElement || (n instanceof HTMLObjectElement && ((HTMLObjectElement)n).getCode() != null));
  }

  // A collection of all AREA elements and anchor (A) elements in a document with a value for the href attribute.
  @Override
  public HTMLCollection getLinks() {
    return elements(n -> (n instanceof HTMLAnchorElement || n instanceof HTMLAreaElement) && ((Element)n).hasAttribute("href") );
  }

  // A collection of all the anchor (A) elements in a document with a value for the name attribute.
  @Override
  public HTMLCollection getAnchors() {
    return elements(n -> n instanceof HTMLAnchorElement && ((Element)n).hasAttribute("name") );
  }

  @Override public NodeList getElementsByTagName(String tagname) { return HtmlElement.byTag(childNodes,tagname); }
  
  // TODO:

  @Override public String getTitle() { return null; }
  @Override public void setTitle(String title) {}

  @Override public HTMLElement getBody() { return null; }
  @Override public void setBody(HTMLElement body) {}

  @Override public void open() {}
  @Override public void close() {}
  @Override public void write(String text) {}
  @Override public void writeln(String text) {}

}
