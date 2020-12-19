package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLBaseElement;

public class HtmlBaseElement extends HtmlElement implements HTMLBaseElement {
  protected HtmlBaseElement(HTMLDocument owner) { super(owner,"BASE"); }

  @Override public String getHref() { return getAttribute("href"); }
  @Override public void setHref(String href) { setAttribute("href",href); }

  @Override public String getTarget() { return getAttribute("target"); }
  @Override public void setTarget(String target) { setAttribute("target",target); }

}
