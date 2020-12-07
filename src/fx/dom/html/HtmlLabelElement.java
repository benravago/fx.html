package fx.dom.html;
import org.w3c.dom.html.HTMLFormElement;
import org.w3c.dom.html.HTMLLabelElement;
class HtmlLabelElement extends HtmlElement implements HTMLLabelElement {

  @Override public HTMLFormElement getForm() { return null; }
  @Override public String getAccessKey() { return null; }
  @Override public void setAccessKey(String accessKey) {}
  @Override public String getHtmlFor() { return null; }
  @Override public void setHtmlFor(String htmlFor) {}
}
