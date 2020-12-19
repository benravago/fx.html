package fx.dom.html;

import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLBodyElement;

public class HtmlBodyElement extends HtmlElement implements HTMLBodyElement {
  protected HtmlBodyElement(HTMLDocument owner) { super(owner,"BODY"); }

  @Override public String getBackground() { return getAttribute("background"); }
  @Override public void setBackground(String background) { setAttribute("background",background); }

  @Override public String getBgColor() { return getAttribute("bgcolor"); }
  @Override public void setBgColor(String bgColor) { setAttribute("bgcolor",bgColor); }

  @Override public String getText() { return getAttribute("text"); }
  @Override public void setText(String text) { setAttribute("text",text); }

  @Override public String getLink() { return getAttribute("link"); }
  @Override public void setLink(String link) { setAttribute("link",link); }

  @Override public String getVLink() { return getAttribute("vlink"); }
  @Override public void setVLink(String vLink) { setAttribute("vlink",vLink); }

  @Override public String getALink() { return getAttribute("alink"); }
  @Override public void setALink(String aLink) { setAttribute("alink",aLink); }

}
