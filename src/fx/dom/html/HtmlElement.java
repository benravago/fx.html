package fx.dom.html;

import org.w3c.dom.html.HTMLElement;

import fx.dom.core.XmlElement;

class HtmlElement extends XmlElement implements HTMLElement {

    HtmlElement() { super(null,null); }

    @Override public String getId() { return null; }
    @Override public void setId(String id) {}
    @Override public String getTitle() { return null; }
    @Override public void setTitle(String title) {}
    @Override public String getLang() { return null; }
    @Override public void setLang(String lang) {}
    @Override public String getDir() { return null; }
    @Override public void setDir(String dir) {}
    @Override public String getClassName() { return null; }
    @Override public void setClassName(String className) {}
}
