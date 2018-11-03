package com.gitlab.martinpiz097.htmlbuilder.html.types;

public class HtmlEmptyElement extends HTMLContentElement {

    public HtmlEmptyElement(String name) {
        super(name);
    }

    public HtmlEmptyElement(String name, HTMLElement parent) {
        super(name, parent, null);
    }

    @Override
    public String draw() {
        StringBuilder sbHtml = new StringBuilder();
        sbHtml.append('<').append(name);
        appendAttributes(sbHtml);
        sbHtml.append("/>\n");
        return sbHtml.toString();
    }
}
