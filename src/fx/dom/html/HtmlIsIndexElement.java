package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLFormElement;
import org.w3c.dom.html.HTMLIsIndexElement;

public class HtmlIsIndexElement extends HtmlElement implements HTMLIsIndexElement, Control {
  protected HtmlIsIndexElement(HTMLDocument owner) { super(owner,"ISINDEX"); }

  @Override public HTMLFormElement getForm() { return Control.form(this); }

  @Override public String getPrompt() { return getAttribute("prompt"); }
  @Override public void setPrompt(String prompt) { setAttribute("prompt",prompt); }

}
