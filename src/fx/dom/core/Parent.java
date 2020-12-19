package fx.dom.core;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public abstract class Parent extends XmlNode {

  protected XmlNodeList childNodes;

  Parent(String name, Document owner) {
    super(name,owner);
    resetChildNodes();
  }

  Node release(Node newChild) {
    mutable();
    if (! acceptable(newChild) || ancestor(newChild)) {
      throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR,"");
    }
    var i = (NamedItem) newChild;
    if (i.list != null) XmlNodeList.unlink(i);
    return newChild;
  }

  abstract boolean acceptable(Node child);

  boolean ancestor(Node reference) {
    for (Node ancestor = this; ancestor != null; ancestor = ancestor.getParentNode()) {
      if (ancestor == reference) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean hasChildNodes() {
    return childNodes.size > 0;
  }

  @Override
  public XmlNodeList getChildNodes() {
    return childNodes;
  }

  final void resetChildNodes() {
    childNodes = new XmlNodeList(this);
  }

  @Override
  public Node getFirstChild() {
    return childNodes.size > 0 ? childNodes.nodes[0] : null;
  }

  @Override
  public Node getLastChild() {
    var n = childNodes.size;
    return n > 0 ? childNodes.nodes[n-1] : null;
  }

  // TODO: when newChild is a DocumentFragment,
  //       how to apply the block of fragment elements?
  //       applies to appendChild(), insertBefore() and replaceChild()

  @Override
  public Node appendChild(Node newChild) throws DOMException {
    return childNodes.append(release(newChild));
  }

  @Override
  public Node insertBefore(Node newChild, Node refChild) throws DOMException {
    return refChild != null
      ? childNodes.insert(release(newChild),refChild)
      : appendChild(newChild);
  }

  @Override
  public Node replaceChild(Node newChild, Node oldChild) throws DOMException {
    if (oldChild == null) {
      throw new DOMException(DOMException.NO_MODIFICATION_ALLOWED_ERR,"");
    }
    return newChild != null
      ? childNodes.replace(release(newChild),oldChild)
      : removeChild(oldChild);
  }

  @Override
  public Node removeChild(Node oldChild) throws DOMException {
    mutable();
    if (!childNodes.remove(oldChild)) {
      throw new DOMException(DOMException.NOT_FOUND_ERR,"");
    }
    return oldChild;
  }

  void cloneChildrenTo(Node to, boolean deep) {
    if (deep) {
      for (var n : childNodes) {
        to.appendChild(n.cloneNode(deep));
      }
    }
  }

}
