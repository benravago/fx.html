package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLStyleElement;

public class HtmlStyleElement extends HtmlElement implements HTMLStyleElement {
  protected HtmlStyleElement(HTMLDocument owner) { super(owner,"STYLE"); }

  @Override public boolean getDisabled() { return false; }
  @Override public void setDisabled(boolean disabled) {}

  @Override public String getType() { return getAttribute("type"); }
  @Override public void setType(String type) { setAttribute("type",type); }

  @Override public String getMedia() { return getAttribute("media"); }
  @Override public void setMedia(String media) { setAttribute("media",media); }

}
