package fx.dom.html;

class Elements {

  static HtmlElement create(String name, HtmlDocument doc) {
    name = name.toUpperCase();
    return switch (name) {

      case "A" -> new HtmlAnchorElement(doc);
      case "APPLET" -> new HtmlAppletElement(doc);
      case "AREA" -> new HtmlAreaElement(doc);
      case "BASE" -> new HtmlBaseElement(doc);
      case "BASEFONT" -> new HtmlBaseFontElement(doc);
      case "BODY" -> new HtmlBodyElement(doc);
      case "BR" -> new HtmlBRElement(doc);
      case "BUTTON" -> new HtmlButtonElement(doc);
      case "CAPTION" -> new HtmlTableCaptionElement(doc);
      case "DIR" -> new HtmlDirectoryElement(doc);
      case "DIV" -> new HtmlDivElement(doc);
      case "DL" -> new HtmlDListElement(doc);
      case "FIELDSET" -> new HtmlFieldSetElement(doc);
      case "FONT" -> new HtmlFontElement(doc);
      case "FORM" -> new HtmlFormElement(doc);
      case "FRAME" -> new HtmlFrameElement(doc);
      case "FRAMESET" -> new HtmlFrameSetElement(doc);
      case "HEAD" -> new HtmlHeadElement(doc);
      case "HR" -> new HtmlHRElement(doc);
      case "HTML" -> new HtmlHtmlElement(doc);
      case "IFRAME" -> new HtmlIFrameElement(doc);
      case "IMG" -> new HtmlImageElement(doc);
      case "INPUT" -> new HtmlInputElement(doc);
      case "ISINDEX" -> new HtmlIsIndexElement(doc);
      case "LABEL" -> new HtmlLabelElement(doc);
      case "LEGEND" -> new HtmlLegendElement(doc);
      case "LI" -> new HtmlLIElement(doc);
      case "LINK" -> new HtmlLinkElement(doc);
      case "MAP" -> new HtmlMapElement(doc);
      case "MENU" -> new HtmlMenuElement(doc);
      case "META" -> new HtmlMetaElement(doc);
      case "OBJECT" -> new HtmlObjectElement(doc);
      case "OL" -> new HtmlOListElement(doc);
      case "OPTGROUP" -> new HtmlOptGroupElement(doc);
      case "OPTION" -> new HtmlOptionElement(doc);
      case "P" -> new HtmlParagraphElement(doc);
      case "PARAM" -> new HtmlParamElement(doc);
      case "PRE" -> new HtmlPreElement(doc);
      case "SCRIPT" -> new HtmlScriptElement(doc);
      case "SELECT" -> new HtmlSelectElement(doc);
      case "STYLE" -> new HtmlStyleElement(doc);
      case "TABLE" -> new HtmlTableElement(doc);
      case "TEXTAREA" -> new HtmlTextAreaElement(doc);
      case "TITLE" -> new HtmlTitleElement(doc);
      case "TR" -> new HtmlTableRowElement(doc);
      case "UL" -> new HtmlUListElement(doc);
      case "BLOCKQUOTE", "Q" -> new HtmlQuoteElement(doc,name);
      case "DEL", "INS" -> new HtmlModElement(doc,name);
      case "H1", "H2", "H3", "H4", "H5", "H6" -> new HtmlHeadingElement(doc,name);
      case "COL","COLGROUP" -> new HtmlTableColElement(doc,name);
      case "TD", "TH" -> new HtmlTableCellElement(doc,name);
      case "TBODY", "TFOOT", "THEAD" -> new HtmlTableSectionElement(doc,name);

      default -> new HtmlElement(doc,name);

      //  ABBR ACRONYM ADDRESS B BDO BIG CENTER CITE CODE
      //  DD DFN DT EM FRAMESET I KBD NOFRAMES NOSCRIPT
      //  S SAMP SMALL SPAN STRIKE STRONG SUB SUP TT U VAR
    };
  }
}
