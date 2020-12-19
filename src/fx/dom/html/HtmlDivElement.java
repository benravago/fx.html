package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLDivElement;

public class HtmlDivElement extends HtmlElement implements HTMLDivElement {
  protected HtmlDivElement(HTMLDocument owner) { super(owner,"DIV"); }

  @Override public String getAlign() { return getAttribute("align"); }
  @Override public void setAlign(String align) { setAttribute("align",align); }

}
