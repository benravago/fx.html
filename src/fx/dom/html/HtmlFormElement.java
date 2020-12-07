package fx.dom.html;
import org.w3c.dom.html.HTMLCollection;
import org.w3c.dom.html.HTMLFormElement;
class HtmlFormElement extends HtmlElement implements HTMLFormElement {

  @Override public HTMLCollection getElements() { return null; }
  @Override public int getLength() { return 0; }
  @Override public String getName() { return null; }
  @Override public void setName(String name) {}
  @Override public String getAcceptCharset() { return null; }
  @Override public void setAcceptCharset(String acceptCharset) {}
  @Override public String getAction() { return null; }
  @Override public void setAction(String action) {}
  @Override public String getEnctype() { return null; }
  @Override public void setEnctype(String enctype) {}
  @Override public String getMethod() { return null; }
  @Override public void setMethod(String method) {}
  @Override public String getTarget() { return null; }
  @Override public void setTarget(String target) {}
  @Override public void submit() {}
  @Override public void reset() {}
}
