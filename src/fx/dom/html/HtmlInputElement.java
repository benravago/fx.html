package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLFormElement;
import org.w3c.dom.html.HTMLInputElement;

public class HtmlInputElement extends HtmlElement implements HTMLInputElement, Control {
  protected HtmlInputElement(HTMLDocument owner) { super(owner,"INPUT"); }

  @Override public void blur() {}
  @Override public void focus() {}
  @Override public void select() {}
  @Override public void click() {}

  @Override public HTMLFormElement getForm() { return Control.form(this); }

  @Override public String getDefaultValue() { return null; }
  @Override public void setDefaultValue(String defaultValue) {}

  @Override public boolean getDefaultChecked() { return false; }
  @Override public void setDefaultChecked(boolean defaultChecked) {}

  @Override public String getType() { return getAttribute("type"); }

  @Override public String getName() { return getAttribute("name"); }
  @Override public void setName(String name) { setAttribute("name",name); }

  @Override public String getValue() { return getAttribute("value"); }
  @Override public void setValue(String value) { setAttribute("value",value); }

  @Override public boolean getChecked() { return isSet("checked"); }
  @Override public void setChecked(boolean checked) { set("checked",checked); }

  @Override public String getSize() { return getAttribute("size"); }
  @Override public void setSize(String size) { setAttribute("size",size); }

  @Override public int getMaxLength() { return integer(getAttribute("maxlength")); }
  @Override public void setMaxLength(int maxLength) { setAttribute("maxlength",Integer.toString(maxLength)); }

  @Override public String getSrc() { return getAttribute("src"); }
  @Override public void setSrc(String src) { setAttribute("src",src); }

  @Override public String getAlt() { return getAttribute("alt"); }
  @Override public void setAlt(String alt) { setAttribute("alt",alt); }

  @Override public String getUseMap() { return getAttribute("usemap"); }
  @Override public void setUseMap(String useMap) { setAttribute("usemap",useMap); }

  @Override public String getAlign() { return getAttribute("align"); }
  @Override public void setAlign(String align) { setAttribute("align",align); }

  @Override public boolean getDisabled() { return isSet("disabled"); }
  @Override public void setDisabled(boolean disabled) { set("disabled",disabled); }

  @Override public boolean getReadOnly() { return isSet("readonly"); }
  @Override public void setReadOnly(boolean readOnly) { set("readonly",readOnly); }

  @Override public String getAccept() { return getAttribute("accept"); }
  @Override public void setAccept(String accept) { setAttribute("accept",accept); }

  @Override public String getAccessKey() { return getAttribute("access-key"); }
  @Override public void setAccessKey(String accessKey) { setAttribute("access-key",accessKey); }

  @Override public int getTabIndex() { return integer(getAttribute("tabindex")); }
  @Override public void setTabIndex(int tabIndex) { setAttribute("tabindex",Integer.toString(tabIndex)); }

}
