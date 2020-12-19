package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLDirectoryElement;

public class HtmlDirectoryElement extends HtmlElement implements HTMLDirectoryElement {
  protected HtmlDirectoryElement(HTMLDocument owner) { super(owner,"DIR"); }

  @Override public boolean getCompact() { return isSet("compact"); }
  @Override public void setCompact(boolean compact) { set("compact",compact); }

}
