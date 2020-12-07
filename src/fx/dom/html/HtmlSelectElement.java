package fx.dom.html;
import org.w3c.dom.DOMException;
import org.w3c.dom.html.HTMLCollection;
import org.w3c.dom.html.HTMLElement;
import org.w3c.dom.html.HTMLFormElement;
import org.w3c.dom.html.HTMLSelectElement;
class HtmlSelectElement extends HtmlElement implements HTMLSelectElement {

  @Override public String getType() { return null; }
  @Override public int getSelectedIndex() { return 0; }
  @Override public void setSelectedIndex(int selectedIndex) {}
  @Override public String getValue() { return null; }
  @Override public void setValue(String value) {}
  @Override public int getLength() { return 0; }
  @Override public HTMLFormElement getForm() { return null; }
  @Override public HTMLCollection getOptions() { return null; }
  @Override public boolean getDisabled() { return false; }
  @Override public void setDisabled(boolean disabled) {}
  @Override public boolean getMultiple() { return false; }
  @Override public void setMultiple(boolean multiple) {}
  @Override public String getName() { return null; }
  @Override public void setName(String name) {}
  @Override public int getSize() { return 0; }
  @Override public void setSize(int size) {}
  @Override public int getTabIndex() { return 0; }
  @Override public void setTabIndex(int tabIndex) {}
  @Override public void add(HTMLElement element, HTMLElement before) throws DOMException {}
  @Override public void remove(int index) {}
  @Override public void blur() {}
  @Override public void focus() {}
}
