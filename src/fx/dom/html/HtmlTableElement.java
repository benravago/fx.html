package fx.dom.html;
import org.w3c.dom.DOMException;
import org.w3c.dom.html.HTMLCollection;
import org.w3c.dom.html.HTMLElement;
import org.w3c.dom.html.HTMLTableCaptionElement;
import org.w3c.dom.html.HTMLTableElement;
import org.w3c.dom.html.HTMLTableSectionElement;
class HtmlTableElement extends HtmlElement implements HTMLTableElement {

  @Override public HTMLTableCaptionElement getCaption() { return null; }
  @Override public void setCaption(HTMLTableCaptionElement caption) {}
  @Override public HTMLTableSectionElement getTHead() { return null; }
  @Override public void setTHead(HTMLTableSectionElement tHead) {}
  @Override public HTMLTableSectionElement getTFoot() { return null; }
  @Override public void setTFoot(HTMLTableSectionElement tFoot) {}
  @Override public HTMLCollection getRows() { return null; }
  @Override public HTMLCollection getTBodies() { return null; }
  @Override public String getAlign() { return null; }
  @Override public void setAlign(String align) {}
  @Override public String getBgColor() { return null; }
  @Override public void setBgColor(String bgColor) {}
  @Override public String getBorder() { return null; }
  @Override public void setBorder(String border) {}
  @Override public String getCellPadding() { return null; }
  @Override public void setCellPadding(String cellPadding) {}
  @Override public String getCellSpacing() { return null; }
  @Override public void setCellSpacing(String cellSpacing) {}
  @Override public String getFrame() { return null; }
  @Override public void setFrame(String frame) {}
  @Override public String getRules() { return null; }
  @Override public void setRules(String rules) {}
  @Override public String getSummary() { return null; }
  @Override public void setSummary(String summary) {}
  @Override public String getWidth() { return null; }
  @Override public void setWidth(String width) {}
  @Override public HTMLElement createTHead() { return null; }
  @Override public void deleteTHead() {}
  @Override public HTMLElement createTFoot() { return null; }
  @Override public void deleteTFoot() {}
  @Override public HTMLElement createCaption() { return null; }
  @Override public void deleteCaption() {}
  @Override public HTMLElement insertRow(int index) throws DOMException { return null; }
  @Override public void deleteRow(int index) throws DOMException {}
}
