package fx.dom.html;

import org.w3c.dom.Node;
import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLFormElement;
import org.w3c.dom.html.HTMLOptionElement;

public class HtmlOptionElement extends HtmlElement implements HTMLOptionElement, Control {
  protected HtmlOptionElement(HTMLDocument owner) { super(owner,"OPTION"); }

  @Override public HTMLFormElement getForm() { return Control.form(this); }

  @Override
  public int getIndex() {
    Node n = this;
    while ((n = n.getParentNode()) != null) {
      if (n instanceof HtmlSelectElement) {
        var x = 0;
        for (var c : ((HtmlSelectElement)n).options()) {
          if (c == this) return x;
          x++;
        }
      }
    }
    return -1;
  }

  @Override public String getText() { return Content.getText(this); }
  // set text via Content.setText(node,value);

  @Override public boolean getDefaultSelected() { return false; }
  @Override public void setDefaultSelected(boolean defaultSelected) {}

  @Override public String getValue() { return getAttribute("value"); }
  @Override public void setValue(String value) { setAttribute("value",value); }

  @Override public boolean getSelected() { return isSet("selected"); }
  @Override public void setSelected(boolean selected) { set("selected",selected); }

  @Override public boolean getDisabled() { return isSet("disabled"); }
  @Override public void setDisabled(boolean disabled) { set("disabled",disabled); }

  @Override public String getLabel() { return getAttribute("label"); }
  @Override public void setLabel(String label) { setAttribute("label",label); }

}
