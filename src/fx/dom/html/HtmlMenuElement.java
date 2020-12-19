package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLMenuElement;

public class HtmlMenuElement extends HtmlElement implements HTMLMenuElement {
  protected HtmlMenuElement(HTMLDocument owner) { super(owner,"MENU"); }

  @Override public boolean getCompact() { return isSet("compact"); }
  @Override public void setCompact(boolean compact) { set("compact",compact); }

}
