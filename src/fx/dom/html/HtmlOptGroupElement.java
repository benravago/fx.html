package fx.dom.html;
import org.w3c.dom.html.HTMLOptGroupElement;
class HtmlOptGroupElement extends HtmlElement implements HTMLOptGroupElement {

  @Override public boolean getDisabled() { return false; }
  @Override public void setDisabled(boolean disabled) {}
  @Override public String getLabel() { return null; }
  @Override public void setLabel(String label) {}
}
