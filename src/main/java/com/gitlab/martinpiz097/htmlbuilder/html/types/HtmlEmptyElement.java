package com.gitlab.martinpiz097.htmlbuilder.html.types;

public class HtmlEmptyElement extends HTMLContentElement {

    public HtmlEmptyElement(String name) {
        super(name);
    }

    public HtmlEmptyElement(HTMLElement parent, String name) {
        super(parent, name);
    }

    @Override
    public String draw() {
        StringBuilder sbHtml = new StringBuilder();
        sbHtml.append('<').append(name);
        if (hasAttributes()) {
            sbHtml.append(' ');
            for (int i = 0; i < listAttributes.size(); i++) {
                sbHtml.append(listAttributes.get(i).draw())
                        .append(' ');
            }
            sbHtml.deleteCharAt(sbHtml.length()-1);
        }
        sbHtml.append("/>\n");
        return sbHtml.toString();
    }
}
