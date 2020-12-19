package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLParamElement;

public class HtmlParamElement extends HtmlElement implements HTMLParamElement {
  protected HtmlParamElement(HTMLDocument owner) { super(owner,"PARAM"); }

  @Override public String getName() { return getAttribute("name"); }
  @Override public void setName(String name) { setAttribute("name",name); }

  @Override public String getValue() { return getAttribute("value"); }
  @Override public void setValue(String value) { setAttribute("value",value); }

  @Override public String getValueType() { return getAttribute("valuetype"); }
  @Override public void setValueType(String valueType) { setAttribute("valuetype",valueType); }

  @Override public String getType() { return getAttribute("type"); }
  @Override public void setType(String type) { setAttribute("type",type); }

}
