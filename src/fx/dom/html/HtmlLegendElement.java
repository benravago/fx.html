package fx.dom.html;
import org.w3c.dom.html.HTMLFormElement;
import org.w3c.dom.html.HTMLLegendElement;
class HtmlLegendElement extends HtmlElement implements HTMLLegendElement {

  @Override public HTMLFormElement getForm() { return null; }
  @Override public String getAccessKey() { return null; }
  @Override public void setAccessKey(String accessKey) {}
  @Override public String getAlign() { return null; }
  @Override public void setAlign(String align) {}
}
