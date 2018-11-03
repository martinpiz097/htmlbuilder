package com.gitlab.martinpiz097.htmlbuilder.html.elements;

import com.gitlab.martinpiz097.htmlbuilder.html.types.HTMLElement;
import com.gitlab.martinpiz097.htmlbuilder.html.types.HtmlEmptyElement;

public class Meta extends HtmlEmptyElement {
    public Meta() {
        super("meta");
    }

    public Meta(String charset) {
        this();
        addAttribute("charset", charset);
    }
}
