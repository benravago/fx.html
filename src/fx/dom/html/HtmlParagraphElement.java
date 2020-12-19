package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLParagraphElement;

public class HtmlParagraphElement extends HtmlElement implements HTMLParagraphElement {
  protected HtmlParagraphElement(HTMLDocument owner) { super(owner,"P"); }

  @Override public String getAlign() { return getAttribute("align"); }
  @Override public void setAlign(String align) { setAttribute("align",align); }

}
