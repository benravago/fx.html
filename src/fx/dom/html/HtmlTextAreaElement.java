package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLFormElement;
import org.w3c.dom.html.HTMLTextAreaElement;

public class HtmlTextAreaElement extends HtmlElement implements HTMLTextAreaElement, Control {
  protected HtmlTextAreaElement(HTMLDocument owner) { super(owner,"TEXTAREA"); }

  @Override public void blur() {}
  @Override public void focus() {}
  @Override public void select() {}

  @Override public HTMLFormElement getForm() { return Control.form(this); }
  @Override public String getType() { return getAttribute("textarea"); }

  @Override public String getDefaultValue() { return null; }
  @Override public void setDefaultValue(String defaultValue) {}

  @Override public String getName() { return getAttribute("name"); }
  @Override public void setName(String name) { setAttribute("name",name); }

  @Override public int getRows() { return integer(getAttribute("rows")); }
  @Override public void setRows(int rows) { setAttribute("rows",Integer.toString(rows)); }

  @Override public int getCols() { return integer(getAttribute("cols")); }
  @Override public void setCols(int cols) { setAttribute("cols",Integer.toString(cols)); }

  @Override public boolean getDisabled() { return isSet("disabled"); }
  @Override public void setDisabled(boolean disabled) { set("disabled",disabled); }

  @Override public boolean getReadOnly() { return isSet("readonly"); }
  @Override public void setReadOnly(boolean readOnly) { set("readonly",readOnly); }

  @Override public String getAccessKey() { return getAttribute("accesskey"); }
  @Override public void setAccessKey(String accessKey) { setAttribute("accesskey",accessKey); }

  @Override public int getTabIndex() { return integer(getAttribute("tabindex")); }
  @Override public void setTabIndex(int tabIndex) { setAttribute("tabindex",Integer.toString(tabIndex)); }

  @Override public String getValue() { return getAttribute("value"); }
  @Override public void setValue(String value) { setAttribute("value",value); }

}
