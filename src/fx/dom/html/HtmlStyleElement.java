package fx.dom.html;
import org.w3c.dom.html.HTMLStyleElement;
class HtmlStyleElement extends HtmlElement implements HTMLStyleElement {

  @Override public boolean getDisabled() { return false; }
  @Override public void setDisabled(boolean disabled) {}
  @Override public String getMedia() { return null; }
  @Override public void setMedia(String media) {}
  @Override public String getType() { return null; }
  @Override public void setType(String type) {}
}
