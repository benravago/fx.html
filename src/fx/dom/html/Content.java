package fx.dom.html;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.w3c.dom.Node;
import org.w3c.dom.Text;

import fx.dom.core.NamedItemList;
import fx.dom.core.Parent;

public interface Content {

  @SuppressWarnings("unchecked")
  static <T extends Node> T outer(Node n, Class<T> p) {
    while ((n = n.getParentNode()) != null) {
      if (p.isInstance(n)) return (T)n;
    }
    return null;
  }

  static Node find(Parent p, Class<?> t) {
    for (var n : p.getChildNodes()) {
      if (t.isInstance(n)) return n;
      if (n instanceof Parent) {
        var c = find((Parent)n,t);
        if (c != null) return c;
      }
    }
    return null;
  }

  static Node find(Node n, Class<?> t) {
    return n instanceof Parent ? find((Parent)n,t) : null;
  }

  static int indexOf(Parent p, Node n) {
    var i = new int[] {0};
    return find(p,n,n.getClass(),i) ? i[0] : -1;
  }

  static boolean find(Parent p, Node n, Class<?> t, int[] i) {
    for (var c:p.getChildNodes()) {
      if (c == n) return true;
      if (t.isInstance(c)) i[0]++;
      if (c instanceof Parent && find((Parent)c,n,t,i)) return true;
    }
    return false;
  }

  static void walk(NamedItemList list, Consumer<Node> fn) {
    for (var i : list) {
      fn.accept(i);
      if (i instanceof Parent) {
        walk(((Parent)i).getChildNodes(),fn);
      }
    }
  }

  static int count(NamedItemList items, Predicate<Node> pick) {
    var i = new int[]{0};
    walk(items, n -> { if (pick.test(n)) i[0]++; });
    return i[0];
  }

  static List<Node> collect(NamedItemList items, Predicate<Node> pick) {
    var list = new ArrayList<Node>();
    walk(items, n -> { if (pick.test(n)) list.add(n); });
    return list;
  }

  static String getText(Node n) {
    n = n.getFirstChild();
    var b = new StringBuilder();
    while (n != null) {
      if (n instanceof Text) {
        b.append(((Text)n).getData());
      }
      n = n.getNextSibling();
    }
    return b.toString();
  }

  static void setText(Node p, String data) {
    var c = p.getFirstChild();
    while (c != null) {
      var s = c.getNextSibling();
      p.removeChild(c);
      c = s;
    }
    p.insertBefore(p.getOwnerDocument().createTextNode(data), p.getFirstChild());
  }

}
