package fx.dom.html;
import org.w3c.dom.html.HTMLFormElement;
import org.w3c.dom.html.HTMLOptionElement;
class HtmlOptionElement extends HtmlElement implements HTMLOptionElement {

  @Override public HTMLFormElement getForm() { return null; }
  @Override public boolean getDefaultSelected() { return false; }
  @Override public void setDefaultSelected(boolean defaultSelected) {}
  @Override public String getText() { return null; }
  @Override public int getIndex() { return 0; }
  @Override public boolean getDisabled() { return false; }
  @Override public void setDisabled(boolean disabled) {}
  @Override public String getLabel() { return null; }
  @Override public void setLabel(String label) {}
  @Override public boolean getSelected() { return false; }
  @Override public void setSelected(boolean selected) {}
  @Override public String getValue() { return null; }
  @Override public void setValue(String value) {}
}
