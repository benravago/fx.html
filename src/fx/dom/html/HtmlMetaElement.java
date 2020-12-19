package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLMetaElement;

public class HtmlMetaElement extends HtmlElement implements HTMLMetaElement {
  protected HtmlMetaElement(HTMLDocument owner) { super(owner,"META"); }

  @Override public String getName() { return getAttribute("name"); }
  @Override public void setName(String name) { setAttribute("name",name); }

  @Override public String getHttpEquiv() { return getAttribute("http-equiv"); }
  @Override public void setHttpEquiv(String httpEquiv) { setAttribute("http-equiv",httpEquiv); }

  @Override public String getContent() { return getAttribute("content"); }
  @Override public void setContent(String content) { setAttribute("content",content); }

  @Override public String getScheme() { return getAttribute("scheme"); }
  @Override public void setScheme(String scheme) { setAttribute("scheme",scheme); }

}
