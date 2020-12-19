package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLOptGroupElement;

public class HtmlOptGroupElement extends HtmlElement implements HTMLOptGroupElement {
  protected HtmlOptGroupElement(HTMLDocument owner) { super(owner,"OPTGROUP"); }

  @Override public String getLabel() { return getAttribute("label"); }
  @Override public void setLabel(String label) { setAttribute("label",label); }

  @Override public boolean getDisabled() { return isSet("disabled"); }
  @Override public void setDisabled(boolean disabled) { set("disabled",disabled); }

}
