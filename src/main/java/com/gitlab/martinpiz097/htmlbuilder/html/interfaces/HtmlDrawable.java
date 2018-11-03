package com.gitlab.martinpiz097.htmlbuilder.html.interfaces;

import com.gitlab.martinpiz097.htmlbuilder.html.sys.AttributeName;
import com.gitlab.martinpiz097.htmlbuilder.html.types.HTMLAttribute;
import com.gitlab.martinpiz097.htmlbuilder.html.types.HTMLElement;
import org.w3c.dom.Attr;

import java.util.ArrayList;
import java.util.stream.Stream;

import static com.gitlab.martinpiz097.htmlbuilder.html.sys.AttributeName.CLASS;
import static com.gitlab.martinpiz097.htmlbuilder.html.sys.AttributeName.ID;


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
    public default void setClassAttribute(Object htmlclassName) {
        ArrayList<HTMLAttribute> listAttributes = getAttributes();
        Stream<HTMLAttribute> stream = listAttributes.parallelStream()
                .filter(attr -> attr.getKey().equals(CLASS));
        if (stream.count() > 0)
            stream.iterator().remove();
        listAttributes.add(new HTMLAttribute(CLASS, htmlclassName));
    }

    public default void setIdAttribute(Object htmlIdAttribute) {
        ArrayList<HTMLAttribute> listAttributes = getAttributes();
        Stream<HTMLAttribute> stream = listAttributes.parallelStream()
                .filter(attr -> attr.getKey().equals(ID));
        if (stream.count() > 0)
            stream.iterator().remove();
        listAttributes.add(new HTMLAttribute(ID, htmlIdAttribute));
    }

    public ArrayList<HTMLAttribute> getAttributes();
    public HTMLAttribute getAttribute(String name);
    public void setAttributes(ArrayList<HTMLAttribute> listAttributes);
    public void setAttribute(String name, Object value);
    public void deleteAttribute(String name);
    public void deleteAttributes();

    default void appendAttributes(StringBuilder sbHtml) {
        ArrayList<HTMLAttribute> listAttributes = getAttributes();
        if (hasAttributes()) {
            sbHtml.append(' ');
            for (int i = 0; i < listAttributes.size(); i++) {
                sbHtml.append(listAttributes.get(i).draw())
                        .append(' ');
            }
            sbHtml.deleteCharAt(sbHtml.length()-1);
        }
    }
}
