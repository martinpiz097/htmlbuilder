package com.gitlab.martinpiz097.htmlbuilder.html.types;

import com.gitlab.martinpiz097.htmlbuilder.html.interfaces.HtmlDrawable;

import java.util.ArrayList;
import java.util.stream.Collectors;

// crear clase abstracta para elements que solo manejan contenido
public class HTMLElement implements HtmlDrawable {
    protected String name;
    protected HTMLElement parent;
    protected ArrayList<HTMLAttribute> listAttributes;
    protected ArrayList<HtmlDrawable> listChilds;

    public HTMLElement(String name) {
        this(name, null);
    }

    public HTMLElement(String name, HTMLElement parent) {
        this.name = name;
        this.parent = parent;
        listAttributes = new ArrayList<>();
        listChilds = new ArrayList<>();
    }

    @Override
    public boolean hasAttribute(String name) {
        return listAttributes.parallelStream()
                .anyMatch(attr -> attr.getKey().equals(name));
    }

    @Override
    public boolean hasAttributes() {
        return !listAttributes.isEmpty();
    }

    public boolean hasChilds() {
        return !listChilds.isEmpty();
    }

    public boolean hasParent() {
        return parent != null;
    }

    @Override
    public void addAttribute(HTMLAttribute attribute) {
        if (!hasAttribute(attribute.getKey()))
            listAttributes.add(attribute);
    }

    @Override
    public ArrayList<HTMLAttribute> getAttributes() {
        return listAttributes;
    }

    @Override
    public HTMLAttribute getAttribute(String name) {
        return listAttributes.parallelStream()
                .filter(attr->attr.getKey().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
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

    public void addChild(HTMLElement element) {
        element.setParent(this);
        listChilds.add(element);
    }

    public void addChild(HTMLContentElement element) {
        element.setParent(this);
        listChilds.add(element);
    }

    public ArrayList<HtmlDrawable> getChilds() {
        return listChilds;
    }

    public ArrayList<HtmlDrawable> getChildsByName(String name) {
        ArrayList<HtmlDrawable> listChilds =
                (ArrayList<HtmlDrawable>) this.listChilds.stream()
                .filter(child -> child.getName().equals(name))
                .collect(Collectors.toList());

        return listChilds;
    }

    public HtmlDrawable getChildById(Object id) {
        return listChilds
                .parallelStream()
                .filter(child->{
                    HTMLAttribute attr = child.getAttribute("id");
                    return attr != null && attr.getValue().equals(id);
                }).findFirst().orElse(null);
    }

    public void setChilds(ArrayList<HtmlDrawable> listChilds) {
        this.listChilds = listChilds;
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
    public HTMLElement getParent() {
        return parent;
    }

    @Override
    public void setParent(HTMLElement parent) {
        this.parent = parent;
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
        sbHtml.append(">\n");
        for (int i = 0; i < listChilds.size(); i++)
            sbHtml.append(listChilds.get(i).draw());
        sbHtml.append("</").append(name).append(">\n");
        return sbHtml.toString();
    }

}
