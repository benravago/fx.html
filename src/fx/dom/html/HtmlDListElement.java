package fx.dom.html;
import org.w3c.dom.html.HTMLDListElement;
class HtmlDListElement extends HtmlElement implements HTMLDListElement {

  @Override public boolean getCompact() { return false; }
  @Override public void setCompact(boolean compact) {}
}
