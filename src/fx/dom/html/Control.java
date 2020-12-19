package fx.dom.html;

import org.w3c.dom.Node;
import org.w3c.dom.html.HTMLFormElement;

public interface Control {

  static HTMLFormElement form(Node n) {
    return Content.outer(n, HTMLFormElement.class);
  }

  static boolean part(Node n) {
    return n instanceof Control;
  }

}
