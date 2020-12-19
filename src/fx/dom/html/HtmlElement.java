package fx.dom.html;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLElement;

import fx.dom.core.NamedItemList;
import fx.dom.core.XmlElement;

public class HtmlElement extends XmlElement implements HTMLElement {

  // TODO:
  // proper HTML element names are upper-cased
  // proper HTML attribute names are lower-cased

  protected HtmlElement(HTMLDocument owner, String tagName) {
    super(tagName,owner);
  }

  @Override
  public NodeList getElementsByTagName(String name) {
    return byTag(childNodes,name);
  }
  
  static NodeList byTag(NamedItemList children, String name) {  
    return byTagName(children,name::equalsIgnoreCase);  
  }  
   
  @Override
  public Node cloneNode(boolean deep) {
    return null; // not supported
  }

  protected boolean isSet(String name) {
    return getAttributeNode(name) != null;
  }

  protected void set(String name, boolean value) {
    if (value) {
      setAttribute(name,name);
    } else {
      removeAttribute(name);
    }
  }

  protected static int integer(String value) {
    try { return Integer.parseInt(value); }
    catch (NumberFormatException e) { return 0; }
  }

  // common HTML element attributes

  @Override public String getClassName() { return getAttribute("class"); }
  @Override public void setClassName(String className) { setAttribute("class",className); }

  @Override public String getDir() { return getAttribute("dir"); }
  @Override public void setDir(String dir) { setAttribute("dir",dir); }

  @Override public String getId() { return getAttribute("id"); }
  @Override public void setId(String id) { setAttribute("id",id); }

  @Override public String getLang() { return getAttribute("lang"); }
  @Override public void setLang(String lang) { setAttribute("lang",lang); }

  @Override public String getTitle() { return getAttribute("title"); }
  @Override public void setTitle(String title) { setAttribute("title",title); }

}

/*

Methods inherited from interface w3c.dom.Element
  _getAttribute_, _getAttributeNode_,
  _setAttribute_, setAttributeNode
  _removeAttribute_, removeAttributeNode,
  _getElementsByTagName_, getTagName,
  normalize,

Methods inherited from interface w3c.dom.Node
  cloneNode,
  getAttributes, getChildNodes, hasChildNodes,
  getFirstChild, getLastChild,
  getPreviousSibling, getNextSibling,
  getNodeName, getNodeType,
  getNodeValue, setNodeValue,
  getOwnerDocument, getParentNode,
  appendChild, insertBefore, removeChild, replaceChild

*/
