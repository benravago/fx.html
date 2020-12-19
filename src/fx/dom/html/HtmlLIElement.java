package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLLIElement;

public class HtmlLIElement extends HtmlElement implements HTMLLIElement {
  protected HtmlLIElement(HTMLDocument owner) { super(owner,"LI"); }

  @Override public String getType() { return getAttribute("type"); }
  @Override public void setType(String type) { setAttribute("type",type); }

  @Override public int getValue() { return integer(getAttribute("value")); }
  @Override public void setValue(int value) { setAttribute("value",Integer.toString(value)); }

}
