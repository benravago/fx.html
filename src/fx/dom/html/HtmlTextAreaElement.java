package fx.dom.html;
import org.w3c.dom.html.HTMLFormElement;
import org.w3c.dom.html.HTMLTextAreaElement;
class HtmlTextAreaElement extends HtmlElement implements HTMLTextAreaElement {

  @Override public String getDefaultValue() { return null; }
  @Override public void setDefaultValue(String defaultValue) {}
  @Override public HTMLFormElement getForm() { return null; }
  @Override public String getAccessKey() { return null; }
  @Override public void setAccessKey(String accessKey) {}
  @Override public int getCols() { return 0; }
  @Override public void setCols(int cols) {}
  @Override public boolean getDisabled() { return false; }
  @Override public void setDisabled(boolean disabled) {}
  @Override public String getName() { return null; }
  @Override public void setName(String name) {}
  @Override public boolean getReadOnly() { return false; }
  @Override public void setReadOnly(boolean readOnly) {}
  @Override public int getRows() { return 0; }
  @Override public void setRows(int rows) {}
  @Override public int getTabIndex() { return 0; }
  @Override public void setTabIndex(int tabIndex) {}
  @Override public String getType() { return null; }
  @Override public String getValue() { return null; }
  @Override public void setValue(String value) {}
  @Override public void blur() {}
  @Override public void focus() {}
  @Override public void select() {}
}
