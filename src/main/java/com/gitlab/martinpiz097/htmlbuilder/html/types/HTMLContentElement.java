package com.gitlab.martinpiz097.htmlbuilder.html.types;

import com.gitlab.martinpiz097.htmlbuilder.html.interfaces.HtmlDrawable;
import com.gitlab.martinpiz097.htmlbuilder.html.types.HTMLAttribute;
import com.gitlab.martinpiz097.htmlbuilder.html.types.HTMLElement;

import java.util.ArrayList;

public class HTMLContentElement implements HtmlDrawable {
    protected HTMLElement parent;
    protected String name;
    protected ArrayList<HTMLAttribute> listAttributes;
    protected String content;

    public HTMLContentElement(String name) {
        this((HTMLElement) null, name);
    }

    public HTMLContentElement(HTMLElement parent, String name) {
        this(parent, name, null);
    }

    public HTMLContentElement(HTMLElement parent, String name, String content) {
        this.parent = parent;
        this.name = name;
        this.content = content;
        listAttributes = new ArrayList<>();
    }

    public HTMLContentElement(String name, String content) {
        this(null, name, content);
    }

    @Override
    public boolean hasAttribute(String name) {
        return listAttributes.parallelStream()
                .anyMatch(attr->attr.getKey().equals(name));
    }

    @Override
    public boolean hasAttributes() {
        return !listAttributes.isEmpty();
    }

    public boolean hasParent() {
        return parent != null;
    }

    public boolean hasContent() {
        return content != null;
    }

    @Override
    public HTMLElement getParent() {
        return parent;
    }

    @Override
    public void setParent(HTMLElement parent) {
        this.parent = parent;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void addAttribute(HTMLAttribute attr) {
        listAttributes.add(attr);
    }

    @Override
    public ArrayList<HTMLAttribute> getAttributes() {
        return listAttributes;
    }

    @Override
    public HTMLAttribute getAttribute(String name) {
        return null;
    }

    public void setAttributes(ArrayList<HTMLAttribute> listAttributes) {
        this.listAttributes = listAttributes;
    }

    @Override
    public void setAttribute(String name, Object value) {
        HTMLAttribute attribute;
        for (int i = 0; i < listAttributes.size(); i++) {
            attribute = listAttributes.get(i);
            if (attribute.getKey().equals(name)) {
                attribute.setValue(value);
                listAttributes.set(i, attribute);
                break;
            }
        }
    }

    @Override
    public void deleteAttribute(String name) {
        for (int i = 0; i < listAttributes.size(); i++)
            if (listAttributes.get(i).getKey().equals(name))
                listAttributes.remove(i);
    }

    @Override
    public void deleteAttributes() {
        listAttributes.clear();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String draw() {
        StringBuilder sbHtml = new StringBuilder();
        sbHtml.append('<').append(name);
        if (hasAttributes()) {
            sbHtml.append(' ');
            for (int i = 0; i < listAttributes.size(); i++) {
                sbHtml.append(listAttributes.get(i).draw())
                        .append(' ');
            }
            sbHtml.deleteCharAt(sbHtml.length()-1);
        }
        sbHtml.append(">\n")
                .append(content)
                .append("\n</").append(name).append(">\n");
        return sbHtml.toString();
    }

}
