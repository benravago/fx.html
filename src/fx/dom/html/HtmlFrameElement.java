package fx.dom.html;

import org.w3c.dom.Document;
import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLFrameElement;

public class HtmlFrameElement extends HtmlElement implements HTMLFrameElement {
  protected HtmlFrameElement(HTMLDocument owner) { super(owner,"FRAME"); }

  @Override public String getName() { return getAttribute("name"); }
  @Override public void setName(String name) { setAttribute("name",name); }

  @Override public String getSrc() { return getAttribute("src"); }
  @Override public void setSrc(String src) { setAttribute("src",src); }

  @Override public String getLongDesc() { return getAttribute("longdesc"); }
  @Override public void setLongDesc(String longDesc) { setAttribute("longdesc",longDesc); }

  @Override public String getFrameBorder() { return getAttribute("frameborder"); }
  @Override public void setFrameBorder(String frameBorder) { setAttribute("frameborder",frameBorder); }

  @Override public String getMarginWidth() { return getAttribute("marginwidth"); }
  @Override public void setMarginWidth(String marginWidth) { setAttribute("marginwidth",marginWidth); }

  @Override public String getMarginHeight() { return getAttribute("marginheight"); }
  @Override public void setMarginHeight(String marginHeight) { setAttribute("marginheight",marginHeight); }

  @Override public boolean getNoResize() { return isSet("noresize"); }
  @Override public void setNoResize(boolean noResize) { set("noresize",noResize); }

  @Override public String getScrolling() { return getAttribute("scrolling"); }
  @Override public void setScrolling(String scrolling) { setAttribute("scrolling",scrolling); }

  @Override public Document getContentDocument() { return null; }
}
