package com.gitlab.martinpiz097.htmlbuilder.html.elements;

import com.gitlab.martinpiz097.htmlbuilder.html.types.HTMLContentElement;
import com.gitlab.martinpiz097.htmlbuilder.html.types.HTMLElement;

public class H1 extends HTMLContentElement {
    public H1() {
        super("h1");
    }

    public H1(String h1Title) {
        super("h1", h1Title);

    }

    public H1(String h1Title, HTMLElement parent) {
        super("h1", parent, h1Title);
    }
}
