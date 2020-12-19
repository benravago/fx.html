package fx.dom.core;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.EntityReference;
import org.w3c.dom.Node;
import org.w3c.dom.TypeInfo;

public class XmlAttr extends Parent implements Attr {

  String defaultValue;
  boolean specified;

  protected XmlAttr(String name, Document owner) {
    super(valid(name),owner);
    specified = false;
  }

  @Override public short getNodeType() { return Node.ATTRIBUTE_NODE; }

  @Override
  boolean acceptable(Node child) {
    ownable(child);
    return switch(child.getNodeType()) {
      case Node.TEXT_NODE,
           Node.ENTITY_REFERENCE_NODE,
           Token.NODETYPE -> true;
      default -> false;
    };
  }

  // DOM Level 1

  @Override public String getName() { return getNodeName(); }
  @Override public boolean getSpecified() { return specified; }

  @Override
  public String getValue() {
    var buf = new StringBuilder();
    for (Node n : childNodes) {
      if (n instanceof EntityReference) n = ((EntityReference)n).getFirstChild();
      if (n instanceof XmlText) buf.append(((XmlText)n).data);
    }
    return buf.toString();
  }

  @Override
  public void setValue(String value) throws DOMException {
    mutable();
    resetChildNodes();
    if (value != null) appendChild(getOwnerDocument().createTextNode(value));
    specified = true;
  }

  @Override
  void mutable() {
    var p = owner();
    if (p != null) ((XmlNode)p).mutable();
  }

  static void usable(Node n) {
    if (((XmlAttr)n).owner() != null) {
      throw new DOMException(DOMException.INUSE_ATTRIBUTE_ERR,"");
    }
  }

  private Node owner() { return super.getParentNode(); }

  @Override public Node getParentNode() { return null; }

  @Override public Node getNextSibling() { return null; }
  @Override public Node getPreviousSibling() { return null; }

  @Override public String getNodeValue() throws DOMException { return getValue(); }
  @Override public void setNodeValue(String nodeValue) throws DOMException { setValue(nodeValue); }

  @Override
  public Node cloneNode(boolean deep) throws DOMException {
    var a = new XmlAttr(getName(),getOwnerDocument());
    cloneChildrenTo(a,true);
    return a;
  }

  // DOM Level 2
  @Override public Element getOwnerElement() { return null; }
  @Override public TypeInfo getSchemaTypeInfo() { return null; }
  @Override public boolean isId() { return false; }
}
