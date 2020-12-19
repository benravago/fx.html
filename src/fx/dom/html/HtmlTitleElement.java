package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLTitleElement;

public class HtmlTitleElement extends HtmlElement implements HTMLTitleElement {
  protected HtmlTitleElement(HTMLDocument owner) { super(owner,"TITLE"); }

  @Override public String getText() { return Content.getText(this); }
  @Override public void setText(String text) { Content.setText(this,text);}

}
