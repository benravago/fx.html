package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLTableCaptionElement;

public class HtmlTableCaptionElement extends HtmlElement implements HTMLTableCaptionElement {
  protected HtmlTableCaptionElement(HTMLDocument owner) { super(owner,"CAPTION"); }

  @Override public String getAlign() { return getAttribute("align"); }
  @Override public void setAlign(String align) { setAttribute("align",align); }

}
