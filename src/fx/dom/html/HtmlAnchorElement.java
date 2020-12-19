package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLAnchorElement;

public class HtmlAnchorElement extends HtmlElement implements HTMLAnchorElement {
  protected HtmlAnchorElement(HTMLDocument owner) { super(owner,"A"); }

  @Override public void blur() {}
  @Override public void focus() {}

  @Override public String getHref() { return getAttribute("href"); }
  @Override public void setHref(String href) { setAttribute("href",href); }

  @Override public String getName() { return getAttribute("name"); }
  @Override public void setName(String name) { setAttribute("name",name); }

  @Override public String getRel() { return getAttribute("rel"); }
  @Override public void setRel(String rel) { setAttribute("rel",rel); }

  @Override public String getRev() { return getAttribute("rev"); }
  @Override public void setRev(String rev) { setAttribute("rev",rev); }

  @Override public String getType() { return getAttribute("type"); }
  @Override public void setType(String type) { setAttribute("type",type); }

  @Override public String getTarget() { return getAttribute("target"); }
  @Override public void setTarget(String target) { setAttribute("target",target); }

  @Override public String getHreflang() { return getAttribute("hreflang"); }
  @Override public void setHreflang(String hreflang) { setAttribute("hreflang",hreflang); }

  @Override public String getCharset() { return getAttribute("charset"); }
  @Override public void setCharset(String charset) { setAttribute("charset",charset); }

  @Override public String getAccessKey() { return getAttribute("accesskey"); }
  @Override public void setAccessKey(String accessKey) { setAttribute("accesskey",accessKey); }

  @Override public int getTabIndex() { return integer(getAttribute("tabindex")); }
  @Override public void setTabIndex(int tabIndex) { setAttribute("tabindex",Integer.toString(tabIndex)); }

  @Override public String getShape() { return getAttribute("shape"); }
  @Override public void setShape(String shape) { setAttribute("shape",shape); }

  @Override public String getCoords() { return getAttribute("coords"); }
  @Override public void setCoords(String coords) { setAttribute("coords",coords); }

}
