package com.gitlab.martinpiz097.htmlbuilder.html.elements;

import com.gitlab.martinpiz097.htmlbuilder.html.types.HTMLAttribute;
import com.gitlab.martinpiz097.htmlbuilder.html.types.HTMLElement;

public class Html extends HTMLElement {

    public Html() {
        super("html");
        listChilds.add(new Head());
        listChilds.add(new Body());
    }

    public Html(String title) {
        this(title, "UTF-8");
    }

    public Html(String title, String charset) {
        this(title, charset, "en");
    }

    public Html(String title, String charset, String language) {
        super("html");
        listChilds.add(new Head(title, charset));
        listChilds.add(new Body());
        listAttributes.add(new HTMLAttribute("lang", language));
    }

    public HTMLElement getHead() {
        return (HTMLElement) listChilds.get(0);
    }

    public HTMLElement getBody() {
        return (HTMLElement) listChilds.get(1);
    }

}
