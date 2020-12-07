package fx.dom.html;

import org.w3c.dom.NodeList;
import org.w3c.dom.html.HTMLCollection;
import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLElement;

import fx.dom.core.XmlDocument;

class HtmlDocument extends XmlDocument implements HTMLDocument {

    HtmlDocument(String root) { super(root); }
    
    @Override public String getTitle() { return null; }
    @Override public void setTitle(String title) {}
    @Override public String getReferrer() { return null; }
    @Override public String getDomain() { return null; }
    @Override public String getURL() { return null; }
    @Override public HTMLElement getBody() { return null; }
    @Override public void setBody(HTMLElement body) {}
    @Override public HTMLCollection getImages() { return null; }
    @Override public HTMLCollection getApplets() { return null; }
    @Override public HTMLCollection getLinks() { return null; }
    @Override public HTMLCollection getForms() { return null; }
    @Override public HTMLCollection getAnchors() { return null; }
    @Override public String getCookie() { return null; }
    @Override public void setCookie(String cookie) {}
    @Override public void open() {}
    @Override public void close() {}
    @Override public void write(String text) {}
    @Override public void writeln(String text) {}
    @Override public NodeList getElementsByName(String elementName) { return null; } 
}
