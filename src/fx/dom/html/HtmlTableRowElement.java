package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.DOMException;
import org.w3c.dom.html.HTMLCollection;
import org.w3c.dom.html.HTMLElement;
import org.w3c.dom.html.HTMLTableRowElement;

public class HtmlTableRowElement extends HtmlElement implements HTMLTableRowElement {
  protected HtmlTableRowElement(HTMLDocument owner) { super(owner,"TR"); }

  @Override public int getRowIndex() { return 0; } // TODO:
  @Override public int getSectionRowIndex() { return 0; } // TODO:

  @Override public HTMLCollection getCells() { return null; } // TODO:

  @Override public HTMLElement insertCell(int index) throws DOMException { return null; } // TODO:
  @Override public void deleteCell(int index) throws DOMException {} // TODO:


  @Override public String getAlign() { return getAttribute("align"); }
  @Override public void setAlign(String align) { setAttribute("align",align); }

  @Override public String getCh() { return getAttribute("char"); }
  @Override public void setCh(String ch) { setAttribute("char",ch); }

  @Override public String getChOff() { return getAttribute("charoff"); }
  @Override public void setChOff(String chOff) { setAttribute("charoff",chOff); }

  @Override public String getVAlign() { return getAttribute("valign"); }
  @Override public void setVAlign(String vAlign) { setAttribute("valign",vAlign); }

  @Override public String getBgColor() { return getAttribute("bgcolor"); }
  @Override public void setBgColor(String bgColor) { setAttribute("bgcolor",bgColor); }

}
