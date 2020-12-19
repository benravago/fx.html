package fx.dom.html;
import org.w3c.dom.html.HTMLDocument;

import org.w3c.dom.html.HTMLAreaElement;

public class HtmlAreaElement extends HtmlElement implements HTMLAreaElement {
  protected HtmlAreaElement(HTMLDocument owner) { super(owner,"AREA"); }

  @Override public String getAccessKey() { return null; }
  @Override public void setAccessKey(String accessKey) {}

  @Override public String getShape() { return getAttribute("shape"); }
  @Override public void setShape(String shape) { setAttribute("shape",shape); }

  @Override public String getCoords() { return getAttribute("coords"); }
  @Override public void setCoords(String coords) { setAttribute("coords",coords); }

  @Override public String getHref() { return getAttribute("href"); }
  @Override public void setHref(String href) { setAttribute("href",href); }

  @Override public String getTarget() { return getAttribute("target"); }
  @Override public void setTarget(String target) { setAttribute("target",target); }

  @Override public boolean getNoHref() { return isSet("nohref"); }
  @Override public void setNoHref(boolean noHref) { set("nohref",noHref); }

  @Override public String getAlt() { return getAttribute("alt"); }
  @Override public void setAlt(String alt) { setAttribute("alt",alt); }

  @Override public int getTabIndex() { return integer(getAttribute("tabindex")); }
  @Override public void setTabIndex(int tabIndex) { setAttribute("tabindex",Integer.toString(tabIndex)); }

}
