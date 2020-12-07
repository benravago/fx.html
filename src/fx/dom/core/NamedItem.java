package fx.dom.core;

import org.w3c.dom.Node;

public abstract class NamedItem implements Node {
    protected NamedItemList list;
    protected int index;
    protected String nodeName;
}
