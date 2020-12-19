package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLCollection;
import org.w3c.dom.html.HTMLFormElement;

public class HtmlFormElement extends HtmlElement implements HTMLFormElement {
  protected HtmlFormElement(HTMLDocument owner) { super(owner,"FORM"); }

  @Override public HTMLCollection getElements() { return HtmlCollection.of(childNodes,Control::part);  }
  @Override public int getLength() { return Content.count(childNodes,Control::part); }

  @Override public void submit() {}
  @Override public void reset() {}

  @Override public String getName() { return null; }
  @Override public void setName(String name) {}

  @Override public String getAction() { return getAttribute("action"); }
  @Override public void setAction(String action) { setAttribute("action",action); }

  @Override public String getMethod() { return getAttribute("method"); }
  @Override public void setMethod(String method) { setAttribute("method",method); }

  @Override public String getEnctype() { return getAttribute("enctype"); }
  @Override public void setEnctype(String enctype) { setAttribute("enctype",enctype); }

  @Override public String getAcceptCharset() { return getAttribute("accept-charset"); }
  @Override public void setAcceptCharset(String acceptCharset) { setAttribute("accept-charset",acceptCharset); }

  @Override public String getTarget() { return getAttribute("target"); }
  @Override public void setTarget(String target) { setAttribute("target",target); }

}
