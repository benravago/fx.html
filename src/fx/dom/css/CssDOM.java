package fx.dom.css;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSStyleSheet;
import org.w3c.dom.css.DOMImplementationCSS;

import fx.dom.core.XmlDOM;

public class CssDOM extends XmlDOM implements DOMImplementationCSS {

    @Override
    public CSSStyleSheet createCSSStyleSheet(String title, String media) throws DOMException {
        return null;
    }
}
