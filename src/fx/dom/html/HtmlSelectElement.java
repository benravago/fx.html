package fx.dom.html;

import java.util.List;

import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import org.w3c.dom.html.HTMLDocument;
import org.w3c.dom.html.HTMLCollection;
import org.w3c.dom.html.HTMLElement;
import org.w3c.dom.html.HTMLFormElement;
import org.w3c.dom.html.HTMLOptionElement;
import org.w3c.dom.html.HTMLSelectElement;

public class HtmlSelectElement extends HtmlElement implements HTMLSelectElement, Control {
  protected HtmlSelectElement(HTMLDocument owner) { super(owner,"SELECT"); }

  @Override public void blur() {}
  @Override public void focus() {}

  @Override public HTMLFormElement getForm() { return Control.form(this); }

  @Override public HTMLCollection getOptions() { return HtmlCollection.wrap(options()); }
  @Override public int getLength() { return Content.count(childNodes,this::isOption); }

  List<Node> options() { return Content.collect(childNodes, this::isOption); }
  boolean isOption(Node n) { return n instanceof HTMLOptionElement; }

  @Override
  public void add(HTMLElement element, HTMLElement before) throws DOMException {
    assert (element instanceof HTMLOptionElement);
    insertBefore(element,before);
  }

  @Override
  public void remove(int index) {
    if (index > -1) {
      var c = options();
      if (index < c.size()) {
        var n = c.get(index);
        n.getParentNode().removeChild(n);
      }
    }
  }

  @Override
  public int getSelectedIndex() {
    var x = 0;
    for (var i : options()) {
      if (i == this) return x;
      x++;
    }
    return -1;
  }

  @Override
  public void setSelectedIndex(int selectedIndex) {
    var x = 0;
    for (var i : options()) {
      ((HTMLOptionElement)i).setSelected(x == selectedIndex);
      x++;
    }
  }

  @Override public String getType() { return getMultiple() ? "select-multiple" : "select-one"; }

  @Override public String getValue() { return null; }
  @Override public void setValue(String value) {}

  @Override public String getName() { return getAttribute("name"); }
  @Override public void setName(String name) { setAttribute("name",name); }

  @Override public boolean getMultiple() { return isSet("multiple"); }
  @Override public void setMultiple(boolean multiple) { set("multiple",multiple); }

  @Override public int getSize() { return integer(getAttribute("size")); }
  @Override public void setSize(int size) { setAttribute("size",Integer.toString(size)); }

  @Override public boolean getDisabled() { return isSet("disabled"); }
  @Override public void setDisabled(boolean disabled) { set("disabled",disabled); }

  @Override public int getTabIndex() { return integer(getAttribute("tabindex")); }
  @Override public void setTabIndex(int tabIndex) { setAttribute("tabindex",Integer.toBinaryString(tabIndex)); }

}
