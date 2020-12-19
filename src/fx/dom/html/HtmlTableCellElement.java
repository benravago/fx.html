package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLTableCellElement;

public class HtmlTableCellElement extends HtmlElement implements HTMLTableCellElement {
  protected HtmlTableCellElement(HTMLDocument owner, String cell) { super(owner,cell); } // TH, TD

  @Override public int getCellIndex() { return 0; } // TODO:


  @Override public int getRowSpan() { return integer(getAttribute("rowspan")); }
  @Override public void setRowSpan(int rowSpan) { setAttribute("rowspan",Integer.toString(rowSpan)); }

  @Override public int getColSpan() { return integer(getAttribute("colspan")); }
  @Override public void setColSpan(int colSpan) { setAttribute("colspan",Integer.toString(colSpan)); }

  @Override public String getHeaders() { return getAttribute("headers"); }
  @Override public void setHeaders(String headers) { setAttribute("headers",headers); }

  @Override public String getAbbr() { return getAttribute("abbr"); }
  @Override public void setAbbr(String abbr) { setAttribute("abbr",abbr); }

  @Override public String getScope() { return getAttribute("scope"); }
  @Override public void setScope(String scope) { setAttribute("scope",scope); }

  @Override public String getAxis() { return getAttribute("axis"); }
  @Override public void setAxis(String axis) { setAttribute("axis",axis); }

  @Override public String getAlign() { return getAttribute("align"); }
  @Override public void setAlign(String align) { setAttribute("align",align); }

  @Override public String getCh() { return getAttribute("char"); }
  @Override public void setCh(String ch) { setAttribute("char",ch); }

  @Override public String getChOff() { return getAttribute("charoff"); }
  @Override public void setChOff(String chOff) { setAttribute("charoff",chOff); }

  @Override public String getVAlign() { return getAttribute("valign"); }
  @Override public void setVAlign(String vAlign) { setAttribute("valign",vAlign); }

  @Override public String getWidth() { return getAttribute("width"); }
  @Override public void setWidth(String width) { setAttribute("width",width); }

  @Override public String getHeight() { return getAttribute("height"); }
  @Override public void setHeight(String height) { setAttribute("height",height); }

  @Override public boolean getNoWrap() { return isSet("nowrap"); }
  @Override public void setNoWrap(boolean noWrap) { set("nowrap",noWrap); }

  @Override public String getBgColor() { return getAttribute("bgcolor"); }
  @Override public void setBgColor(String bgColor) { setAttribute("bgcolor",bgColor); }

}
