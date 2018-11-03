package com.gitlab.martinpiz097.htmlbuilder.html.types;

public class HTMLAttribute {
    private String key;
    private Object value;

    public HTMLAttribute(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String draw() {
        return key+'='+value.toString();
    }

    @Override
    public String toString() {
        return "HTMLAttribute{" +
                "key='" + key + '\'' +
                ", value=" + value +
                '}';
    }

}
