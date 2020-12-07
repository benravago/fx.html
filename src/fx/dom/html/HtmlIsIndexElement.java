package fx.dom.html;
import org.w3c.dom.html.HTMLFormElement;
import org.w3c.dom.html.HTMLIsIndexElement;
class HtmlIsIndexElement extends HtmlElement implements HTMLIsIndexElement {

  @Override public HTMLFormElement getForm() { return null; }
  @Override public String getPrompt() { return null; }
  @Override public void setPrompt(String prompt) {}
}
