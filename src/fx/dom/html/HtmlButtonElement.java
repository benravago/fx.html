package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLButtonElement;
import org.w3c.dom.html.HTMLFormElement;

public class HtmlButtonElement extends HtmlElement implements HTMLButtonElement, Control {
  protected HtmlButtonElement(HTMLDocument owner) { super(owner,"BUTTON"); }

  @Override public HTMLFormElement getForm() { return Control.form(this); }

  @Override public String getName() { return getAttribute("name"); }
  @Override public void setName(String name) { setAttribute("name",name); }

  @Override public String getValue() { return getAttribute("value"); }
  @Override public void setValue(String value) { setAttribute("value",value); }

  @Override public String getType() { return getAttribute("type"); }

  @Override public boolean getDisabled() { return isSet("disabled"); }
  @Override public void setDisabled(boolean disabled) { set("disabled",disabled); }

  @Override public String getAccessKey() { return getAttribute("accesskey"); }
  @Override public void setAccessKey(String accessKey) { setAttribute("accesskey",accessKey); }

  @Override public int getTabIndex() { return integer(getAttribute("tabindex")); }
  @Override public void setTabIndex(int tabIndex) { setAttribute("tabindex",Integer.toString(tabIndex)); }

}
