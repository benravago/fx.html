package fx.dom.core;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.EntityReference;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlEntityReference extends XmlNode implements EntityReference {

  Node reference;

  protected XmlEntityReference(String name, Document owner) {
    super(valid(name),owner);
    immutable = true;

    var dtd = getOwnerDocument().getDoctype();
    if (dtd != null) reference = dtd.getEntities().getNamedItem(getNodeName());
    if (reference == null) reference = new Token("null",null,getOwnerDocument());
  }

  @Override public short getNodeType() { return Node.ENTITY_REFERENCE_NODE; }

  @Override public Node appendChild(Node newChild) throws DOMException { return reference.appendChild(newChild); }
  @Override public Node cloneNode(boolean deep) throws DOMException { return getOwnerDocument().createEntityReference(getNodeName()); }
  @Override public NodeList getChildNodes() { return reference.getChildNodes(); }
  @Override public boolean hasChildNodes() { return reference.hasChildNodes(); }
  @Override public Node getFirstChild() { return reference.getFirstChild(); }
  @Override public Node getLastChild() { return reference.getLastChild(); }
  @Override public Node insertBefore(Node newChild, Node refChild) throws DOMException { throw new DOMException(DOMException.NO_MODIFICATION_ALLOWED_ERR,""); }
  @Override public Node removeChild(Node oldChild) throws DOMException { throw new DOMException(DOMException.NO_MODIFICATION_ALLOWED_ERR,""); }
  @Override public Node replaceChild(Node newChild, Node oldChild) throws DOMException { throw new DOMException(DOMException.NO_MODIFICATION_ALLOWED_ERR,""); }
}
