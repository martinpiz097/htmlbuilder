package com.gitlab.martinpiz097.htmlbuilder.html.interfaces;

import com.gitlab.martinpiz097.htmlbuilder.html.types.HTMLAttribute;
import com.gitlab.martinpiz097.htmlbuilder.html.types.HTMLElement;

import java.util.ArrayList;


public interface HtmlDrawable extends Drawable{
    public boolean hasAttributes();
    public boolean hasAttribute(String name);
    public String getName();
    public void setName(String name);
    public HTMLElement getParent();
    public void setParent(HTMLElement parent);

    public void addAttribute(HTMLAttribute attr);
    public default void addAttribute(String key, Object value) {
        addAttribute(new HTMLAttribute(key, value));
    }
    public ArrayList<HTMLAttribute> getAttributes();
    public HTMLAttribute getAttribute(String name);
    public void setAttributes(ArrayList<HTMLAttribute> listAttributes);
    public void setAttribute(String name, Object value);
    public void deleteAttribute(String name);
    public void deleteAttributes();

}
