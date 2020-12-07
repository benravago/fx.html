package fx.dom.html;
import org.w3c.dom.html.HTMLOListElement;
class HtmlOListElement extends HtmlElement implements HTMLOListElement {

  @Override public boolean getCompact() { return false; }
  @Override public void setCompact(boolean compact) {}
  @Override public int getStart() { return 0; }
  @Override public void setStart(int start) {}
  @Override public String getType() { return null; }
  @Override public void setType(String type) {}
}
