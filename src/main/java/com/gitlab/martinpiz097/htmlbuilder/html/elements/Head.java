package com.gitlab.martinpiz097.htmlbuilder.html.elements;

import com.gitlab.martinpiz097.htmlbuilder.html.types.HTMLElement;

public class Head extends HTMLElement {
    public Head() {
        super("head");
    }

    public Head(String title) {
        this(title, "UTF-8");
    }

    public Head(String title, String charset) {
        super("head");
        addChild(new Title(this, title));
        addChild(new Meta(charset));
    }

}
