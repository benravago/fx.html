package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLBaseFontElement;

public class HtmlBaseFontElement extends HtmlElement implements HTMLBaseFontElement {
  protected HtmlBaseFontElement(HTMLDocument owner) { super(owner,"BASEFONT"); }

  @Override public String getSize() { return getAttribute("size"); }
  @Override public void setSize(String size) { setAttribute("size",size); }

  @Override public String getColor() { return getAttribute("color"); }
  @Override public void setColor(String color) { setAttribute("color",color); }

  @Override public String getFace() { return getAttribute("face"); }
  @Override public void setFace(String face) { setAttribute("face",face); }

}
