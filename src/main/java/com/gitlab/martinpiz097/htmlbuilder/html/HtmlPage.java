package com.gitlab.martinpiz097.htmlbuilder.html;

import com.gitlab.martinpiz097.htmlbuilder.html.elements.Html;
import com.gitlab.martinpiz097.htmlbuilder.html.interfaces.Drawable;

public class HtmlPage implements Drawable {

    private Html html;

    public HtmlPage() {
        html = new Html();
    }

    public HtmlPage(String title) {
        html = new Html(title);
    }

    public HtmlPage(String title, String charset) {
        html = new Html(title, charset);
    }

    public HtmlPage(String title, String charset, String language) {
        html = new Html(title, charset, language);
    }

    @Override
    public String draw() {
        StringBuilder sbHtml = new StringBuilder();
        sbHtml.append("<!DOCTYPE html>\n");
        sbHtml.append(html.draw());
        return sbHtml.toString();
    }
}
