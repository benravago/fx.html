package fx.dom.html;
import org.w3c.dom.html.HTMLMenuElement;
class HtmlMenuElement extends HtmlElement implements HTMLMenuElement {

  @Override public boolean getCompact() { return false; }
  @Override public void setCompact(boolean compact) {}
}
