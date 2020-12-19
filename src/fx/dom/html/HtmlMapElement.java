package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLAreaElement;
import org.w3c.dom.html.HTMLCollection;
import org.w3c.dom.html.HTMLMapElement;

public class HtmlMapElement extends HtmlElement implements HTMLMapElement {
  protected HtmlMapElement(HTMLDocument owner) { super(owner,"MAP"); }

  @Override
  public HTMLCollection getAreas() {
    return HtmlCollection.of(childNodes, n -> n instanceof HTMLAreaElement );
  }

  @Override public String getName() { return getAttribute("name"); }
  @Override public void setName(String name) { setAttribute("name",name); }

}
