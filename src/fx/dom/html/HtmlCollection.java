package fx.dom.html;

import java.util.List;
import java.util.function.Predicate;

import org.w3c.dom.Node;
import org.w3c.dom.html.HTMLCollection;

import fx.dom.core.NamedItemList;

class HtmlCollection {

  static HTMLCollection of(NamedItemList items, Predicate<Node> pick) {
    var list = Content.collect(items,pick);
    return list.isEmpty() ? EMPTY : wrap(list);
  }

  static HTMLCollection wrap(List<Node> list) {
    return new HTMLCollection() {

      @Override
      public int getLength() { return list.size(); }

      @Override
      public Node item(int index) { return list.get(index); }

      @Override
      public Node namedItem(String name) {
        for (var n:list) if (n.getNodeName().equals(name)) return n;
        return null;
      }

    };
  }

  static final HTMLCollection EMPTY = new HTMLCollection() {
    @Override public int getLength() { return 0; }
    @Override public Node item(int index) { return null; }
    @Override public Node namedItem(String name) { return null; }
  };

}
