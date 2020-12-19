package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLImageElement;

public class HtmlImageElement extends HtmlElement implements HTMLImageElement {
  protected HtmlImageElement(HTMLDocument owner) { super(owner,"IMG"); }

  @Override public String getName() { return null; }
  @Override public void setName(String name) {}

  @Override public String getLowSrc() { return null; }
  @Override public void setLowSrc(String lowSrc) {}

  @Override public String getSrc() { return getAttribute("src"); }
  @Override public void setSrc(String src) { setAttribute("src",src); }

  @Override public String getAlt() { return getAttribute("alt"); }
  @Override public void setAlt(String alt) { setAttribute("alt",alt); }

  @Override public String getLongDesc() { return getAttribute("longdesc"); }
  @Override public void setLongDesc(String longDesc) { setAttribute("longdesc",longDesc); }

  @Override public String getWidth() { return getAttribute("width"); }
  @Override public void setWidth(String width) { setAttribute("width",width); }

  @Override public String getHeight() { return getAttribute("height"); }
  @Override public void setHeight(String height) { setAttribute("height",height); }

  @Override public String getUseMap() { return getAttribute("usemap"); }
  @Override public void setUseMap(String useMap) { setAttribute("usemap",useMap); }

  @Override public boolean getIsMap() { return isSet("ismap"); }
  @Override public void setIsMap(boolean isMap) { set("ismap",isMap); }

  @Override public String getAlign() { return getAttribute("align"); }
  @Override public void setAlign(String align) { setAttribute("align",align); }

  @Override public String getBorder() { return getAttribute("border"); }
  @Override public void setBorder(String border) { setAttribute("border",border); }

  @Override public String getHspace() { return getAttribute("hspace"); }
  @Override public void setHspace(String hspace) { setAttribute("hspace",hspace); }

  @Override public String getVspace() { return getAttribute("vspace"); }
  @Override public void setVspace(String vspace) { setAttribute("vspace",vspace); }

}
