package fx.dom.html;
import org.w3c.dom.html.HTMLUListElement;
class HtmlUListElement extends HtmlElement implements HTMLUListElement {

  @Override public boolean getCompact() { return false; }
  @Override public void setCompact(boolean compact) {}
  @Override public String getType() { return null; }
  @Override public void setType(String type) {}
}
