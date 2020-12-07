package fx.dom.html;

import org.w3c.dom.html.HTMLDOMImplementation;
import org.w3c.dom.html.HTMLDocument;

import fx.dom.core.XmlDOM;

public class HtmlDOM extends XmlDOM implements HTMLDOMImplementation {

    @Override
    public HTMLDocument createHTMLDocument(String title) {
        return null;
    }
}
