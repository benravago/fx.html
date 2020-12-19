package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLHRElement;

public class HtmlHRElement extends HtmlElement implements HTMLHRElement {
  protected HtmlHRElement(HTMLDocument owner) { super(owner,"HR"); }

  @Override public String getAlign() { return getAttribute("align"); }
  @Override public void setAlign(String align) { setAttribute("align",align); }

  @Override public boolean getNoShade() { return isSet("noshade"); }
  @Override public void setNoShade(boolean noShade) { set("noshade",noShade); }

  @Override public String getSize() { return getAttribute("size"); }
  @Override public void setSize(String size) { setAttribute("size",size); }

  @Override public String getWidth() { return getAttribute("width"); }
  @Override public void setWidth(String width) { setAttribute("width",width); }

}
