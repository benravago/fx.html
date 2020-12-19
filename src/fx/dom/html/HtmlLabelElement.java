package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLFormElement;
import org.w3c.dom.html.HTMLLabelElement;

public class HtmlLabelElement extends HtmlElement implements HTMLLabelElement, Control {
  protected HtmlLabelElement(HTMLDocument owner) { super(owner,"LABEL"); }

  @Override public HTMLFormElement getForm() { return Control.form(this); }

  @Override public String getHtmlFor() { return getAttribute("for"); }
  @Override public void setHtmlFor(String htmlFor) { setAttribute("for",htmlFor); }

  @Override public String getAccessKey() { return getAttribute("accesskey"); }
  @Override public void setAccessKey(String accessKey) { setAttribute("accesskey",accessKey); }

}
