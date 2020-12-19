package fx.dom.core;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;

public class XmlElement extends Parent implements Element {

  XmlNamedNodeMap attributes;

  protected XmlElement(String tagName, Document owner) {
    super(valid(tagName),owner);
    attributes = new XmlNamedNodeMap(this);
    setDefaultAttributes();
  }

  @Override public short getNodeType() { return Node.ELEMENT_NODE; }

  @Override
  boolean acceptable(Node child) {
    ownable(child);
    return switch(child.getNodeType()) {
      case Node.ELEMENT_NODE,
           Node.COMMENT_NODE,
           Node.TEXT_NODE,
           Node.CDATA_SECTION_NODE,
           Node.PROCESSING_INSTRUCTION_NODE,
           Node.ENTITY_REFERENCE_NODE,
           Token.NODETYPE -> true;
      default -> false;
    };
  }

  // DOM Level 1

  @Override
  public void normalize() {
    for (var n : childNodes) {
      if (n instanceof Element) {
        ((Element)n).normalize();
      } else if (n instanceof XmlText) {
        ((XmlText)n).normalizeText();
      }
    }
    for (var a:attributes) {
      if (a instanceof XmlText) {
        ((XmlText)a).normalizeText();
      }
    }
  }

  @Override
  public String getTagName() {
    return getNodeName();
  }

  @Override
  public NodeList getElementsByTagName(String name) {
    return byName(childNodes,name);
  }
  
  static NodeList byName(NamedItemList children, String name) {
    return byTagName(children,name::equals);  
  }
  
  protected static NodeList byTagName(NamedItemList children, Predicate<String> m) {
    var list = new ArrayList<Node>();
    walk(children, e -> { if (m.test(e.getTagName())) list.add(e); });
    return XmlNodeList.of(list);
  }

  static void walk(NamedItemList list, Consumer<XmlElement> fn) {
    for (var i : list) {
      if (i instanceof XmlElement) {
        fn.accept((XmlElement)i);
        walk(((XmlElement)i).childNodes,fn);
      }
    }
  }

  @Override
  public NamedNodeMap getAttributes() {
    return attributes;
  }

  @Override
  public String getAttribute(String name) {
    var a = getAttributeNode(name);
    return (a != null) ? a.getValue() : "";
  }

  @Override
  public Attr getAttributeNode(String name) {
    return (Attr) attributes.getNamedItem(name);
  }

  @Override
  public void setAttribute(String name, String value) throws DOMException {
    var a = (Attr) attributes.getNamedItem(name);
    if (a != null) {
      a.setValue(value);
    } else {
      a = getOwnerDocument().createAttribute(name);
      a.setValue(value);
      setAttributeNode(a);
    }
  }

  @Override
  public Attr setAttributeNode(Attr newAttr) throws DOMException {
    return (Attr) attributes.setNamedItem(newAttr);
  }

  @Override
  public void removeAttribute(String name) throws DOMException {
    attributes.removeNamedItem(name);
  }

  @Override
  public Attr removeAttributeNode(Attr oldAttr) throws DOMException {
    mutable();
    if (!attributes.remove(oldAttr)) {
      throw new DOMException(DOMException.NOT_FOUND_ERR,"");
    }
    removed(oldAttr);
    return oldAttr;
  }

  void removed(Node n) {
    if (n instanceof XmlAttr) {
      var a = (XmlAttr)n;
      if (a.defaultValue != null) {
        addDefaultAttribute(n.getNodeName(),a.defaultValue);
      }
    }
  }

  Node dtdDeclarations() {
    var dtd = (XmlDocumentType) getOwnerDocument().getDoctype();
    if (dtd != null) {
      var map = dtd.elements;
      if (map.getLength() > 0) {
        return map.item(0);
      }
    }
    return null;
  }

  private void setDefaultAttributes() {
    var e = dtdDeclarations();
    while (e != null) {
      if (e.getNodeName().equals(getNodeName())) {
        var j = e.getAttributes().getLength();
        for (var i = 0; i < j; i++) {
          var a = (Attr) e.getAttributes().item(i);
          var v = a.getValue();
          if (v != null && v.length() > 0 && v.charAt(0) != '#') {
            addDefaultAttribute(a.getName(),v);
          }
        }
        break;
      }
      e = (Element) e.getNextSibling();
    }
  }

  void addDefaultAttribute(String name, String value) {
    var n = (XmlAttr) getOwnerDocument().createAttribute(name);
    n.setValue(value);
    n.defaultValue = value;
    setAttributeNode(n);
    n.specified = false;
  }

  @Override
  public Node cloneNode(boolean deep) throws DOMException {
    var e = getOwnerDocument().createElement(getTagName());
    for (var n : attributes) {
      e.setAttributeNode((Attr) n.cloneNode(true));
    }
    cloneChildrenTo(e,deep);
    return e;
  }

  // DOM Level 2
  @Override public String getAttributeNS(String namespaceURI, String localName) throws DOMException { return null; }
  @Override public void setAttributeNS(String namespaceURI, String qualifiedName, String value) throws DOMException {}
  @Override public void removeAttributeNS(String namespaceURI, String localName) throws DOMException {}
  @Override public Attr getAttributeNodeNS(String namespaceURI, String localName) throws DOMException { return null; }
  @Override public Attr setAttributeNodeNS(Attr newAttr) throws DOMException { return null; }
  @Override public NodeList getElementsByTagNameNS(String namespaceURI, String localName) throws DOMException { return null; }
  @Override public boolean hasAttribute(String name) { return false; }
  @Override public boolean hasAttributeNS(String namespaceURI, String localName) throws DOMException { return false; }
  @Override public TypeInfo getSchemaTypeInfo() { return null; }
  @Override public void setIdAttribute(String name, boolean isId) throws DOMException {}
  @Override public void setIdAttributeNS(String namespaceURI, String localName, boolean isId) throws DOMException {}
  @Override public void setIdAttributeNode(Attr idAttr, boolean isId) throws DOMException {}
}
