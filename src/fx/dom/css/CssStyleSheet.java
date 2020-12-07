package fx.dom.css;

import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSRuleList;
import org.w3c.dom.css.CSSStyleSheet;

class CssStyleSheet implements CSSStyleSheet {

    @Override public String getType() { return null; }
    @Override public boolean getDisabled() { return false; }
    @Override public void setDisabled(boolean disabled) {}
    @Override public Node getOwnerNode() { return null; }
    @Override public org.w3c.dom.stylesheets.StyleSheet getParentStyleSheet() { return null; }
    @Override public String getHref() { return null; }
    @Override public String getTitle() { return null; }
    @Override public org.w3c.dom.stylesheets.MediaList getMedia() { return null; }
    @Override public CSSRule getOwnerRule() { return new CssRule(); }
    @Override public CSSRuleList getCssRules() { return null; }
    @Override public int insertRule(String rule, int index) throws DOMException { return 0; }
    @Override public void deleteRule(int index) throws DOMException {}
}
