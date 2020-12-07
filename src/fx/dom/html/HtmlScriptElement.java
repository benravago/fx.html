package fx.dom.html;
import org.w3c.dom.html.HTMLScriptElement;
class HtmlScriptElement extends HtmlElement implements HTMLScriptElement {

  @Override public String getText() { return null; }
  @Override public void setText(String text) {}
  @Override public String getHtmlFor() { return null; }
  @Override public void setHtmlFor(String htmlFor) {}
  @Override public String getEvent() { return null; }
  @Override public void setEvent(String event) {}
  @Override public String getCharset() { return null; }
  @Override public void setCharset(String charset) {}
  @Override public boolean getDefer() { return false; }
  @Override public void setDefer(boolean defer) {}
  @Override public String getSrc() { return null; }
  @Override public void setSrc(String src) {}
  @Override public String getType() { return null; }
  @Override public void setType(String type) {}
}
