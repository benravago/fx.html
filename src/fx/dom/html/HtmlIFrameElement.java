package fx.dom.html;

import org.w3c.dom.Document;
import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLIFrameElement;

public class HtmlIFrameElement extends HtmlElement implements HTMLIFrameElement {
  protected HtmlIFrameElement(HTMLDocument owner) { super(owner,"IFRAME"); }

  @Override public String getSrc() { return getAttribute("src"); }
  @Override public void setSrc(String src) { setAttribute("src",src); }

  @Override public String getName() { return getAttribute("name"); }
  @Override public void setName(String name) { setAttribute("name",name); }

  @Override public String getLongDesc() { return getAttribute("longdesc"); }
  @Override public void setLongDesc(String longDesc) { setAttribute("longdesc",longDesc); }

  @Override public String getWidth() { return getAttribute("width"); }
  @Override public void setWidth(String width) { setAttribute("width",width); }

  @Override public String getHeight() { return getAttribute("height"); }
  @Override public void setHeight(String height) { setAttribute("height",height); }

  @Override public String getAlign() { return getAttribute("align"); }
  @Override public void setAlign(String align) { setAttribute("align",align); }

  @Override public String getFrameBorder() { return getAttribute("frameborder"); }
  @Override public void setFrameBorder(String frameBorder) { setAttribute("frameborder",frameBorder); }

  @Override public String getMarginWidth() { return getAttribute("marginwidth"); }
  @Override public void setMarginWidth(String marginWidth) { setAttribute("marginwidth",marginWidth); }

  @Override public String getMarginHeight() { return getAttribute("marginheight"); }
  @Override public void setMarginHeight(String marginHeight) { setAttribute("marginheight",marginHeight); }

  @Override public String getScrolling() { return getAttribute("scrolling"); }
  @Override public void setScrolling(String scrolling) { setAttribute("scrolling",scrolling); }

  @Override public Document getContentDocument() { return null; }
}
