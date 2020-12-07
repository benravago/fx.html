package fx.dom.html;
import org.w3c.dom.html.HTMLButtonElement;
import org.w3c.dom.html.HTMLFormElement;
class HtmlButtonElement extends HtmlElement implements HTMLButtonElement {

  @Override public HTMLFormElement getForm() { return null; }
  @Override public String getAccessKey() { return null; }
  @Override public void setAccessKey(String accessKey) {}
  @Override public boolean getDisabled() { return false; }
  @Override public void setDisabled(boolean disabled) {}
  @Override public String getName() { return null; }
  @Override public void setName(String name) {}
  @Override public int getTabIndex() { return 0; }
  @Override public void setTabIndex(int tabIndex) {}
  @Override public String getType() { return null; }
  @Override public String getValue() { return null; }
  @Override public void setValue(String value) {}
}
