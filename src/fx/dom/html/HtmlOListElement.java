package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLOListElement;

public class HtmlOListElement extends HtmlElement implements HTMLOListElement {
  protected HtmlOListElement(HTMLDocument owner) { super(owner,"OL"); }

  @Override public String getType() { return getAttribute("type"); }
  @Override public void setType(String type) { setAttribute("type",type); }

  @Override public int getStart() { return integer(getAttribute("start")); }
  @Override public void setStart(int start) { setAttribute("start",Integer.toString(start)); }

  @Override public boolean getCompact() { return isSet("compact"); }
  @Override public void setCompact(boolean compact) { set("compact",compact); }

}
