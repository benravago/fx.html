package fx.dom.css;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSStyleSheet;

class CssRule implements CSSRule {

    @Override public short getType() { return 0; }
    @Override public String getCssText() { return null; }
    @Override public void setCssText(String cssText) throws DOMException {}
    @Override public CSSStyleSheet getParentStyleSheet() { return null; }
    @Override public CSSRule getParentRule() { return null; }
}
