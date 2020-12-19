package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLFieldSetElement;
import org.w3c.dom.html.HTMLFormElement;

public class HtmlFieldSetElement extends HtmlElement implements HTMLFieldSetElement, Control {
  protected HtmlFieldSetElement(HTMLDocument owner) { super(owner,"FIELDSET"); }

  @Override public HTMLFormElement getForm() { return Control.form(this); }
}
