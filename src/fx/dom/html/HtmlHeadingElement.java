package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLHeadingElement;

public class HtmlHeadingElement extends HtmlElement implements HTMLHeadingElement {
  protected HtmlHeadingElement(HTMLDocument owner, String level) { super(owner,level); } // H{1,2,3,4,5,6}

  @Override public String getAlign() { return getAttribute("align"); }
  @Override public void setAlign(String align) { setAttribute("align",align); }

}
