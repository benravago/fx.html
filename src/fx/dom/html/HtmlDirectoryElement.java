package fx.dom.html;
import org.w3c.dom.html.HTMLDirectoryElement;
class HtmlDirectoryElement extends HtmlElement implements HTMLDirectoryElement {

  @Override public boolean getCompact() { return false; }
  @Override public void setCompact(boolean compact) {}
}
