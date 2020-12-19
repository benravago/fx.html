package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLTableColElement;

public class HtmlTableColElement extends HtmlElement implements HTMLTableColElement {
  protected HtmlTableColElement(HTMLDocument owner, String tag) { super(owner,tag); }

  @Override public int getSpan() { return integer(getAttribute("span")); }
  @Override public void setSpan(int span) { setAttribute("span",Integer.toString(span)); }

  @Override public String getWidth() { return getAttribute("width"); }
  @Override public void setWidth(String width) { setAttribute("width",width); }

  @Override public String getAlign() { return getAttribute("align"); }
  @Override public void setAlign(String align) { setAttribute("align",align); }

  @Override public String getCh() { return getAttribute("char"); }
  @Override public void setCh(String ch) { setAttribute("char",ch); }

  @Override public String getChOff() { return getAttribute("charoff"); }
  @Override public void setChOff(String chOff) { setAttribute("charoff",chOff); }

  @Override public String getVAlign() { return getAttribute("valign"); }
  @Override public void setVAlign(String vAlign) { setAttribute("valign",vAlign); }

}
