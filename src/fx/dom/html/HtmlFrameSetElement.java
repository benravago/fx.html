package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLFrameSetElement;

public class HtmlFrameSetElement extends HtmlElement implements HTMLFrameSetElement {
  protected HtmlFrameSetElement(HTMLDocument owner) { super(owner,"FRAMESET"); }

  @Override public String getRows() { return getAttribute("rows"); }
  @Override public void setRows(String rows) { setAttribute("rows",rows); }

  @Override public String getCols() { return getAttribute("cols"); }
  @Override public void setCols(String cols) { setAttribute("cols",cols); }

}
