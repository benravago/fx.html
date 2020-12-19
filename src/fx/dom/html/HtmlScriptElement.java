package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLScriptElement;

public class HtmlScriptElement extends HtmlElement implements HTMLScriptElement {
  protected HtmlScriptElement(HTMLDocument owner) { super(owner,"SCRIPT"); }

  @Override public String getText() { return Content.getText(this); }
  @Override public void setText(String text) { Content.setText(this,text);}

  @Override public String getEvent() { return null; }
  @Override public void setEvent(String event) {}

  @Override public String getType() { return getAttribute("type"); }
  @Override public void setType(String type) { setAttribute("type",type); }

  @Override public String getHtmlFor() { return getAttribute("language"); }
  @Override public void setHtmlFor(String htmlFor) { setAttribute("language",htmlFor); }

  @Override public String getSrc() { return getAttribute("src"); }
  @Override public void setSrc(String src) { setAttribute("src",src); }

  @Override public String getCharset() { return getAttribute("charset"); }
  @Override public void setCharset(String charset) { setAttribute("charset",charset); }

  @Override public boolean getDefer() { return isSet("defer"); }
  @Override public void setDefer(boolean defer) { set("defer",defer); }

}
