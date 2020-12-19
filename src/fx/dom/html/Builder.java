package fx.dom.html;

public class Builder extends fx.dom.core.Builder {

  @Override protected HtmlDocument newDocument() { return new HtmlDocument(); }
  @Override protected boolean compareName(String a, String b) { return a.equalsIgnoreCase(b); }

}
