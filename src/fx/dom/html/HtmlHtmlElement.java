package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLHtmlElement;

public class HtmlHtmlElement extends HtmlElement implements HTMLHtmlElement {
  protected HtmlHtmlElement(HTMLDocument owner) { super(owner,"HTML"); }

  @Override public String getVersion() { return getAttribute("version"); }
  @Override public void setVersion(String version) { setAttribute("version",version); }

}
