package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLBRElement;

public class HtmlBRElement extends HtmlElement implements HTMLBRElement {
  protected HtmlBRElement(HTMLDocument owner) { super(owner,"BR"); }

  @Override public String getClear() { return getAttribute("clear"); }
  @Override public void setClear(String clear) { setAttribute("clear",clear); }

}
