package fx.dom.html;

import org.w3c.dom.Document;
import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLFormElement;
import org.w3c.dom.html.HTMLObjectElement;

public class HtmlObjectElement extends HtmlElement implements HTMLObjectElement, Control {
  protected HtmlObjectElement(HTMLDocument owner) { super(owner,"OBJECT"); }

  @Override public HTMLFormElement getForm() { return Control.form(this); }

  @Override public String getData() { return getAttribute("data"); }
  @Override public void setData(String data) { setAttribute("data",data); }

  @Override public String getCode() { return getAttribute("classid"); }
  @Override public void setCode(String code) { setAttribute("classid",code); }

  @Override public String getArchive() { return getAttribute("archive"); }
  @Override public void setArchive(String archive) { setAttribute("archive",archive); }

  @Override public String getCodeBase() { return getAttribute("codebase"); }
  @Override public void setCodeBase(String codeBase) { setAttribute("codebase",codeBase); }

  @Override public String getWidth() { return getAttribute("width"); }
  @Override public void setWidth(String width) { setAttribute("width",width); }

  @Override public String getHeight() { return getAttribute("height"); }
  @Override public void setHeight(String height) { setAttribute("height",height); }

  @Override public String getName() { return getAttribute("name"); }
  @Override public void setName(String name) { setAttribute("name",name); }

  @Override public String getUseMap() { return getAttribute("usemap"); }
  @Override public void setUseMap(String useMap) { setAttribute("usemap",useMap); }

  @Override public String getType() { return getAttribute("type"); }
  @Override public void setType(String type) { setAttribute("type",type); }

  @Override public String getCodeType() { return getAttribute("codetype"); }
  @Override public void setCodeType(String codeType) { setAttribute("codetype",codeType); }

  @Override public String getStandby() { return getAttribute("standby"); }
  @Override public void setStandby(String standby) { setAttribute("standby",standby); }

  @Override public int getTabIndex() { return integer(getAttribute("tabindex")); }
  @Override public void setTabIndex(int tabIndex) { setAttribute("tabindex",Integer.toString(tabIndex)); }

  @Override public boolean getDeclare() { return isSet("declare"); }
  @Override public void setDeclare(boolean declare) { set("declare",declare); }

  @Override public String getAlign() { return getAttribute("align"); }
  @Override public void setAlign(String align) { setAttribute("align",align); }

  @Override public String getBorder() { return getAttribute("border"); }
  @Override public void setBorder(String border) { setAttribute("border",border); }

  @Override public String getHspace() { return getAttribute("hspace"); }
  @Override public void setHspace(String hspace) { setAttribute("hspace",hspace); }

  @Override public String getVspace() { return getAttribute("vspace"); }
  @Override public void setVspace(String vspace) { setAttribute("vspace",vspace); }

  @Override public Document getContentDocument() { return null; }
}
