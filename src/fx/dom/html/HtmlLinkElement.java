package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLLinkElement;

public class HtmlLinkElement extends HtmlElement implements HTMLLinkElement {
  protected HtmlLinkElement(HTMLDocument owner) { super(owner,"LINK"); }

  @Override public boolean getDisabled() { return false; }
  @Override public void setDisabled(boolean disabled) {}

  @Override public String getRel() { return getAttribute("rel"); }
  @Override public void setRel(String rel) { setAttribute("rel",rel); }

  @Override public String getRev() { return getAttribute("rev"); }
  @Override public void setRev(String rev) { setAttribute("rev",rev); }

  @Override public String getHref() { return getAttribute("href"); }
  @Override public void setHref(String href) { setAttribute("href",href); }

  @Override public String getType() { return getAttribute("type"); }
  @Override public void setType(String type) { setAttribute("type",type); }

  @Override public String getTarget() { return getAttribute("target"); }
  @Override public void setTarget(String target) { setAttribute("target",target); }

  @Override public String getMedia() { return getAttribute("media"); }
  @Override public void setMedia(String media) { setAttribute("media",media); }

  @Override public String getHreflang() { return getAttribute("hreflang"); }
  @Override public void setHreflang(String hreflang) { setAttribute("hreflang",hreflang); }

  @Override public String getCharset() { return getAttribute("charset"); }
  @Override public void setCharset(String charset) { setAttribute("charset",charset); }

}
