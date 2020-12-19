package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLUListElement;

public class HtmlUListElement extends HtmlElement implements HTMLUListElement {
  protected HtmlUListElement(HTMLDocument owner) { super(owner,"UL"); }

  @Override public String getType() { return getAttribute("type"); }
  @Override public void setType(String type) { setAttribute("type",type); }

  @Override public boolean getCompact() { return isSet("compact"); }
  @Override public void setCompact(boolean compact) { set("compact",compact); }

}
