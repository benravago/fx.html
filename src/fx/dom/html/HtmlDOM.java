package fx.dom.html;

import org.w3c.dom.html.HTMLDOMImplementation;
import org.w3c.dom.html.HTMLDocument;

import fx.dom.core.XmlDOM;

public class HtmlDOM extends XmlDOM implements HTMLDOMImplementation {

  @Override
  public HTMLDocument createHTMLDocument(String title) {
    if (title == null) {
      throw new NullPointerException("Argument 'title' is null.");
    }
    var doc = new HtmlDocument();
    doc.setTitle(title);
    return doc;
  }

}
