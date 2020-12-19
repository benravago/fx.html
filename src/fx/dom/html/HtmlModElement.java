package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLModElement;

public class HtmlModElement extends HtmlElement implements HTMLModElement {
  protected HtmlModElement(HTMLDocument owner, String mod) { super(owner,mod); } // INS, DEL

  @Override public String getCite() { return getAttribute("cite"); }
  @Override public void setCite(String cite) { setAttribute("cite",cite); }

  @Override public String getDateTime() { return getAttribute("datetime"); }
  @Override public void setDateTime(String dateTime) { setAttribute("datetime",dateTime); }

}
