package fx.dom.css;

import org.w3c.dom.Node;

class StyleSheet implements org.w3c.dom.stylesheets.StyleSheet {

    @Override public String getType() { return null; }
    @Override public boolean getDisabled() { return false; }
    @Override public void setDisabled(boolean disabled) {}
    @Override public Node getOwnerNode() { return null; }
    @Override public org.w3c.dom.stylesheets.StyleSheet getParentStyleSheet() { return null; }
    @Override public String getHref() { return null; }
    @Override public String getTitle() { return null; }
    @Override public org.w3c.dom.stylesheets.MediaList getMedia() { return null; }
}
