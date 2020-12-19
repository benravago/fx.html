package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLQuoteElement;

public class HtmlQuoteElement extends HtmlElement implements HTMLQuoteElement {
  protected HtmlQuoteElement(HTMLDocument owner, String kind) { super(owner,kind); }

  @Override public String getCite() { return getAttribute("cite"); }
  @Override public void setCite(String cite) { setAttribute("cite",cite); }

}
