package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.DOMException;
import org.w3c.dom.html.HTMLCollection;
import org.w3c.dom.html.HTMLElement;
import org.w3c.dom.html.HTMLTableSectionElement;

public class HtmlTableSectionElement extends HtmlElement implements HTMLTableSectionElement {
  protected HtmlTableSectionElement(HTMLDocument owner, String section) { super(owner,section); } // THEAD, TBODY, TFOOT

  @Override public HTMLCollection getRows() { return null; } // TODO:

  @Override public HTMLElement insertRow(int index) throws DOMException { return null; } // TODO:
  @Override public void deleteRow(int index) throws DOMException {} // TODO:


  @Override public String getAlign() { return getAttribute("align"); }
  @Override public void setAlign(String align) { setAttribute("align",align); }

  @Override public String getCh() { return getAttribute("char"); }
  @Override public void setCh(String ch) { setAttribute("char",ch); }

  @Override public String getChOff() { return getAttribute("charoff"); }
  @Override public void setChOff(String chOff) { setAttribute("charoff",chOff); }

  @Override public String getVAlign() { return getAttribute("valign"); }
  @Override public void setVAlign(String vAlign) { setAttribute("valign",vAlign); }

}
