package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLDListElement;

public class HtmlDListElement extends HtmlElement implements HTMLDListElement {
  protected HtmlDListElement(HTMLDocument owner) { super(owner,"DL"); }

  @Override public boolean getCompact() { return isSet("compact"); }
  @Override public void setCompact(boolean compact) { set("compact",compact); }

}
