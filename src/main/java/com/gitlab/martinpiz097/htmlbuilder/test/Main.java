package com.gitlab.martinpiz097.htmlbuilder.test;

import com.gitlab.martinpiz097.htmlbuilder.html.HtmlPage;
import com.gitlab.martinpiz097.htmlbuilder.html.elements.Div;
import com.gitlab.martinpiz097.htmlbuilder.html.elements.H1;
import com.gitlab.martinpiz097.htmlbuilder.html.elements.Html;
import com.gitlab.martinpiz097.htmlbuilder.html.types.HTMLContentElement;
import com.gitlab.martinpiz097.htmlbuilder.html.types.HTMLElement;

public class Main {
    public static void main(String[] args) {
        HtmlPage page = new HtmlPage("Home");
        Html html = page.getHtml();
        HTMLElement body = html.getBody();
        body.addChild(new Div());
        body.addChild(new H1("Titulo xd"));
        body.addChild(new HTMLContentElement("p"));

        System.out.println(page.draw());
    }
}
