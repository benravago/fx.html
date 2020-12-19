package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLAppletElement;

public class HtmlAppletElement extends HtmlElement implements HTMLAppletElement {
  protected HtmlAppletElement(HTMLDocument owner) { super(owner,"APPLET"); }

  @Override public String getCode() { return getAttribute("code"); }
  @Override public void setCode(String code) { setAttribute("code",code); }

  @Override public String getCodeBase() { return getAttribute("codebase"); }
  @Override public void setCodeBase(String codeBase) { setAttribute("codebase",codeBase); }

  @Override public String getWidth() { return getAttribute("width"); }
  @Override public void setWidth(String width) { setAttribute("width",width); }

  @Override public String getHeight() { return getAttribute("height"); }
  @Override public void setHeight(String height) { setAttribute("height",height); }

  @Override public String getArchive() { return getAttribute("archive"); }
  @Override public void setArchive(String archive) { setAttribute("archive",archive); }

  @Override public String getObject() { return getAttribute("object"); }
  @Override public void setObject(String object) { setAttribute("object",object); }

  @Override public String getName() { return getAttribute("name"); }
  @Override public void setName(String name) { setAttribute("name",name); }

  @Override public String getAlt() { return getAttribute("alt"); }
  @Override public void setAlt(String alt) { setAttribute("alt",alt); }

  @Override public String getAlign() { return getAttribute("align"); }
  @Override public void setAlign(String align) { setAttribute("align",align); }

  @Override public String getHspace() { return getAttribute("hspace"); }
  @Override public void setHspace(String hspace) { setAttribute("hspace",hspace); }

  @Override public String getVspace() { return getAttribute("vspace"); }
  @Override public void setVspace(String vspace) { setAttribute("vspace",vspace); }

}
