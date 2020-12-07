package fx.dom.core;

import java.util.List;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlNodeList extends NamedItemList implements NodeList {

  Node append(Node node) {
    assert node instanceof XmlNode;
    insert(size,(XmlNode)node);
    return node;
  }

  Node insert(Node node, Node ref) {
    assert node instanceof XmlNode;
    assert ref instanceof XmlNode;
    insert(((XmlNode)ref).index,(XmlNode)node);
    return node;
  }

  boolean remove(Node node) {
    assert node instanceof XmlNode;
    assert ((XmlNode)node).list == this;
    return unlink((XmlNode)node);
  }

  Node replace(Node node, Node old) {
    assert node instanceof XmlNode;
    assert old instanceof XmlNode;
    replace((XmlNode)node,(XmlNode)old);
    return node;
  }

  static NodeList of(List<Node> list) {
    return new NodeList() {
      @Override public int getLength() { return list.size(); }
      @Override public Node item(int index) { return list.get(index); }
    };
  }

}
