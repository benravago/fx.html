package fx.dom.html;
import org.w3c.dom.DOMException;
import org.w3c.dom.html.HTMLCollection;
import org.w3c.dom.html.HTMLElement;
import org.w3c.dom.html.HTMLTableRowElement;
class HtmlTableRowElement extends HtmlElement implements HTMLTableRowElement {

  @Override public int getRowIndex() { return 0; }
  @Override public int getSectionRowIndex() { return 0; }
  @Override public HTMLCollection getCells() { return null; }
  @Override public String getAlign() { return null; }
  @Override public void setAlign(String align) {}
  @Override public String getBgColor() { return null; }
  @Override public void setBgColor(String bgColor) {}
  @Override public String getCh() { return null; }
  @Override public void setCh(String ch) {}
  @Override public String getChOff() { return null; }
  @Override public void setChOff(String chOff) {}
  @Override public String getVAlign() { return null; }
  @Override public void setVAlign(String vAlign) {}
  @Override public HTMLElement insertCell(int index) throws DOMException { return null; }
  @Override public void deleteCell(int index) throws DOMException {}
}
