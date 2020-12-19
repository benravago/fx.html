package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLHeadElement;

public class HtmlHeadElement extends HtmlElement implements HTMLHeadElement {
  protected HtmlHeadElement(HTMLDocument owner) { super(owner,"HEAD"); }

  @Override public String getProfile() { return getAttribute("profile"); }
  @Override public void setProfile(String profile) { setAttribute("profile",profile); }

}
