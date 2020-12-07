package fx.dom.html;
import org.w3c.dom.DOMException;
import org.w3c.dom.html.HTMLCollection;
import org.w3c.dom.html.HTMLElement;
import org.w3c.dom.html.HTMLTableSectionElement;
class HtmlTableSectionElement extends HtmlElement implements HTMLTableSectionElement {

  @Override public String getAlign() { return null; }
  @Override public void setAlign(String align) {}
  @Override public String getCh() { return null; }
  @Override public void setCh(String ch) {}
  @Override public String getChOff() { return null; }
  @Override public void setChOff(String chOff) {}
  @Override public String getVAlign() { return null; }
  @Override public void setVAlign(String vAlign) {}
  @Override public HTMLCollection getRows() { return null; }
  @Override public HTMLElement insertRow(int index) throws DOMException { return null; }
  @Override public void deleteRow(int index) throws DOMException {}
}
