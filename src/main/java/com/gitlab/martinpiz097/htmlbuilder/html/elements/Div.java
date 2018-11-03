package com.gitlab.martinpiz097.htmlbuilder.html.elements;

import com.gitlab.martinpiz097.htmlbuilder.html.types.HTMLElement;

public class Div extends HTMLElement {
    public Div() {
        super("div");
    }

    public Div(HTMLElement parent) {
        super("div", parent);
    }
}
