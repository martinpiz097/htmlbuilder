package com.gitlab.martinpiz097.htmlbuilder.html.elements;

import com.gitlab.martinpiz097.htmlbuilder.html.types.HTMLContentElement;
import com.gitlab.martinpiz097.htmlbuilder.html.types.HTMLElement;

public class Title extends HTMLContentElement {

    public Title(String content) {
        super("title", content);
    }

    public Title(HTMLElement parent, String content) {
        super(parent, "title", content);
    }
}
