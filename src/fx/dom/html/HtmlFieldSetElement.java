package fx.dom.html;
import org.w3c.dom.html.HTMLFieldSetElement;
import org.w3c.dom.html.HTMLFormElement;
class HtmlFieldSetElement extends HtmlElement implements HTMLFieldSetElement {

  @Override public HTMLFormElement getForm() { return null; }
}
