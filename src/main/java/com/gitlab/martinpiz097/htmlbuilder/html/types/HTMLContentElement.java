package com.gitlab.martinpiz097.htmlbuilder.html.types;

import com.gitlab.martinpiz097.htmlbuilder.html.interfaces.HtmlDrawable;

import java.util.ArrayList;

public class HTMLContentElement extends HTMLElement {
    protected String content;

    public HTMLContentElement(String name) {
        this(name, null, null);
    }

    public HTMLContentElement(String name, HTMLElement parent, String content) {
        super(name, parent);
        this.content = content;
    }

    public HTMLContentElement(String name, String content) {
        this(name, null, content);
    }

    public boolean hasContent() {
        return content != null;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String draw() {
        StringBuilder sbHtml = new StringBuilder();
        sbHtml.append('<').append(name);
        appendAttributes(sbHtml);
        sbHtml.append(">");
        if (content != null)
            sbHtml.append('\n').append(content).append('\n');
        else if (listChilds.size() > 0) {
            sbHtml.append('\n');
            for (int i = 0; i < listChilds.size(); i++)
                sbHtml.append(listChilds.get(i).draw());
            sbHtml.append('\n');
        }
        sbHtml.append("</").append(name).append(">\n");
        return sbHtml.toString();
    }

}
