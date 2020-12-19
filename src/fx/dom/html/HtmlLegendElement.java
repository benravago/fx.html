package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLFormElement;
import org.w3c.dom.html.HTMLLegendElement;

public class HtmlLegendElement extends HtmlElement implements HTMLLegendElement, Control {
  protected HtmlLegendElement(HTMLDocument owner) { super(owner,"LEGEND"); }

  @Override public HTMLFormElement getForm() { return Control.form(this); }

  @Override public String getAccessKey() { return getAttribute("accesskey"); }
  @Override public void setAccessKey(String accessKey) { setAttribute("accesskey",accessKey); }

  @Override public String getAlign() { return getAttribute("align"); }
  @Override public void setAlign(String align) { setAttribute("align",align); }

}
