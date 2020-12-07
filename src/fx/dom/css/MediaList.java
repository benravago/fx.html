package fx.dom.css;

import org.w3c.dom.DOMException;

class MediaList implements org.w3c.dom.stylesheets.MediaList {

    @Override public String getMediaText() { return null; }
    @Override public void setMediaText(String mediaText) throws DOMException {}
    @Override public int getLength() { return 0; }
    @Override public String item(int index) { return null; }
    @Override public void deleteMedium(String oldMedium) throws DOMException {}
    @Override public void appendMedium(String newMedium) throws DOMException {}
}
