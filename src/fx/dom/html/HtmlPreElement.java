package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLPreElement;

public class HtmlPreElement extends HtmlElement implements HTMLPreElement {
  protected HtmlPreElement(HTMLDocument owner) { super(owner,"PRE"); }

  @Override public int getWidth() { return integer(getAttribute("width")); }
  @Override public void setWidth(int width) { setAttribute("width",Integer.toString(width)); }

}
