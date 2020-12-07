package fx.dom.html;
import org.w3c.dom.html.HTMLCollection;
import org.w3c.dom.html.HTMLMapElement;
class HtmlMapElement extends HtmlElement implements HTMLMapElement {

  @Override public HTMLCollection getAreas() { return null; }
  @Override public String getName() { return null; }
  @Override public void setName(String name) {}
}
