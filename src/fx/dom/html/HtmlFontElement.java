package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLFontElement;

public class HtmlFontElement extends HtmlElement implements HTMLFontElement {
  protected HtmlFontElement(HTMLDocument owner) { super(owner,"FONT"); }

  @Override public String getSize() { return getAttribute("size"); }
  @Override public void setSize(String size) { setAttribute("size",size); }

  @Override public String getColor() { return getAttribute("color"); }
  @Override public void setColor(String color) { setAttribute("color",color); }

  @Override public String getFace() { return getAttribute("face"); }
  @Override public void setFace(String face) { setAttribute("face",face); }

}
