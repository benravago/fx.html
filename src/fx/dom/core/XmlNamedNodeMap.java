package fx.dom.core;

import org.w3c.dom.DOMException;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class XmlNamedNodeMap extends XmlNodeList implements NamedNodeMap {

    XmlNamedNodeMap(XmlNode owner) {
      super(owner);
    }

    // DOM Level 1

    @Override
    public Node getNamedItem(String name) {
      return namedItem(name);
    }

    @Override
    public Node setNamedItem(Node node) throws DOMException {
      owner.mutable();
      owner.ownable(node);
      var old = getNamedItem(node.getNodeName());
      if (old == null) {
        append(node); // nodeOp(APPEND,(Sibling)arg,this);
      } else if (old != node) {
        if (old instanceof XmlAttr) XmlAttr.usable(old);
        replace(node,old); // nodeOp(REPLACE,(Sibling)arg,n);
      }
      return old;
    }

    @Override
    public Node removeNamedItem(String name) throws DOMException {
        owner.mutable();
        var node = namedItem(name);
        if (node != null) {
            unlink(node);
            return node;
        }
        throw new DOMException(DOMException.NOT_FOUND_ERR,"");
    }

    // DOM Level 2
    @Override public Node getNamedItemNS(String namespaceURI, String localName) throws DOMException { return null; }
    @Override public Node setNamedItemNS(Node arg) throws DOMException { return null; }
    @Override public Node removeNamedItemNS(String namespaceURI, String localName) throws DOMException { return null; }
}
