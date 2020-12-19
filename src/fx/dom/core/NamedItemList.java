package fx.dom.core;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NamedItemList implements Iterable<NamedItem> {

  NamedItem[] nodes = new NamedItem[8];
  int size = 0;

  public NamedItem item(int index) {
    return (-1 < index && index < size) ? nodes[index] : null;
  }

  public int getLength() {
    return size;
  }

  public NamedItem namedItem(String name) {
    for (var i = 0; i < size; i++) {
      var node = nodes[i];
      if (node.nodeName.equals(name)) {
        return node;
      }
    }
    return null;
  }

  @Override
  public Iterator<NamedItem> iterator() {
    return new Iterator<> () {
      int i = 0;
      NamedItem current;

      @Override
      public boolean hasNext() {
        return i < size;
      }
      @Override
      public NamedItem next() {
        if (i < size) return (current = nodes[i++]);
        throw new NoSuchElementException();
      }
      @Override
      public void remove() {
        unlink(current);
        i--;
      }
    };
  }

  void insert(int index, NamedItem node) {
    assert node.list == null;
    assert index <= nodes.length;
    var n = nodes.length - 1;
    if (index > n || size > n) {
      n = (index > size ? index : size) + (size >> 1);
      assert n > index;
      var d = new NamedItem[n];
      System.arraycopy(nodes,0,d,0,nodes.length);
      nodes = d;
    }
    if (index < size) {
      var j = size;
      while (j > index) { // shift [index,size] right by 1
        var i = j-1;
        (nodes[j] = nodes[i]).index = j;
        j = i;
      }
    }
    nodes[index] = node;
    node.index = index;
    node.list = this;
    size++;
  }

  static boolean unlink(NamedItem node) {
    var list = node.list;
    if (list == null || list.nodes[node.index] != node ) {
      return false;
    }
    var last = list.size - 1;
    var i = node.index;
    var n = list.nodes;
    while (i < last) { // shift [index+1,size] left by 1
      var j = i+1;
      (n[i] = n[j]).index = i;
      i = j;
    }
    node.index = -1;
    node.list = null;
    list.size--;
    return true;
  }

  static void replace(NamedItem newItem, NamedItem oldItem) {
    assert oldItem.list != null;
    assert oldItem.list.nodes[oldItem.index] == oldItem;
    assert newItem.list == null;
    newItem.list = oldItem.list;
    newItem.index = oldItem.index;
    newItem.list.nodes[newItem.index] = newItem;
    oldItem.index = -1;
    oldItem.list = null;
  }

}
