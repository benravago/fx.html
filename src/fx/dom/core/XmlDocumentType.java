package fx.dom.core;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class XmlDocumentType extends XmlNode implements DocumentType {

  XmlNamedNodeMap entities;
  XmlNamedNodeMap notations;
  XmlNamedNodeMap elements;

  protected XmlDocumentType(String name, Document owner) {
    super(name,owner);
    this.entities = new XmlNamedNodeMap(this);
    this.notations = new XmlNamedNodeMap(this);
    this.elements = new XmlNamedNodeMap(this);
    immutable = true;
  }

  @Override public short getNodeType() { return Node.DOCUMENT_TYPE_NODE; }

  @Override
  public Node cloneNode(boolean deep) throws DOMException {
    var e = new XmlDocumentType(getName(),getOwnerDocument());
    e.immutable = false;
    for (var n : entities) e.entities.setNamedItem((XmlEntity) n.cloneNode(true));
    for (var n : notations) e.notations.setNamedItem((XmlNotation) n.cloneNode(true));
    e.immutable = true;
    return e;
  }

  // DOM Level 1
  @Override public NamedNodeMap getEntities() { return entities; }
  @Override public String getName() { return getNodeName(); }
  @Override public NamedNodeMap getNotations() { return notations; }

  // DOM Level 2
  @Override public String getPublicId() { return null; }
  @Override public String getSystemId() { return null; }
  @Override public String getInternalSubset() { return null; }
}
