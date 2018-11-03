package com.gitlab.martinpiz097.htmlbuilder.test;

import com.gitlab.martinpiz097.htmlbuilder.html.HtmlPage;

public class Main {
    public static void main(String[] args) {
        HtmlPage page = new HtmlPage("Home");
        System.out.println(page.draw());
    }
}
