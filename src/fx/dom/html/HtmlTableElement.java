package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;

import org.w3c.dom.DOMException;
import org.w3c.dom.html.HTMLCollection;
import org.w3c.dom.html.HTMLElement;
import org.w3c.dom.html.HTMLTableCaptionElement;
import org.w3c.dom.html.HTMLTableElement;
import org.w3c.dom.html.HTMLTableSectionElement;

public class HtmlTableElement extends HtmlElement implements HTMLTableElement {
  protected HtmlTableElement(HTMLDocument owner) { super(owner,"TABLE"); }

  @Override public HTMLCollection getRows() { return null; } // TODO:
  @Override public HTMLCollection getTBodies() { return null; } // TODO:

  @Override public HTMLTableCaptionElement getCaption() { return null; } // TODO:
  @Override public void setCaption(HTMLTableCaptionElement caption) {} // TODO:

  @Override public HTMLTableSectionElement getTHead() { return null; } // TODO:
  @Override public void setTHead(HTMLTableSectionElement tHead) {} // TODO:

  @Override public HTMLTableSectionElement getTFoot() { return null; } // TODO:
  @Override public void setTFoot(HTMLTableSectionElement tFoot) {} // TODO:

  @Override public HTMLElement createTHead() { return null; } // TODO:
  @Override public void deleteTHead() {} // TODO:

  @Override public HTMLElement createTFoot() { return null; } // TODO:
  @Override public void deleteTFoot() {} // TODO:

  @Override public HTMLElement createCaption() { return null; } // TODO:
  @Override public void deleteCaption() {} // TODO:

  @Override public HTMLElement insertRow(int index) throws DOMException { return null; } // TODO:
  @Override public void deleteRow(int index) throws DOMException {} // TODO:


  @Override public String getSummary() { return getAttribute("summary"); }
  @Override public void setSummary(String summary) { setAttribute("summary",summary); }

  @Override public String getWidth() { return getAttribute("width"); }
  @Override public void setWidth(String width) { setAttribute("width",width); }

  @Override public String getBorder() { return getAttribute("border"); }
  @Override public void setBorder(String border) { setAttribute("border",border); }

  @Override public String getFrame() { return getAttribute("frame"); }
  @Override public void setFrame(String frame) { setAttribute("frame",frame); }

  @Override public String getRules() { return getAttribute("rules"); }
  @Override public void setRules(String rules) { setAttribute("rules",rules); }

  @Override public String getCellSpacing() { return getAttribute("cellspacing"); }
  @Override public void setCellSpacing(String cellSpacing) { setAttribute("cellspacing",cellSpacing); }

  @Override public String getCellPadding() { return getAttribute("cellpadding"); }
  @Override public void setCellPadding(String cellPadding) { setAttribute("cellpadding",cellPadding); }

  @Override public String getAlign() { return getAttribute("align"); }
  @Override public void setAlign(String align) { setAttribute("align",align); }

  @Override public String getBgColor() { return getAttribute("bgcolor"); }
  @Override public void setBgColor(String bgColor) { setAttribute("bgcolor",bgColor); }

}
