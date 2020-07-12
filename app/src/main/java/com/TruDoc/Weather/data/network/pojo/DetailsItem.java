package com.TruDoc.Weather.data.network.pojo;

import java.io.Serializable;

public class DetailsItem implements Serializable {
    private String name;
    private String value;
    private String Icon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getIcon() {
        return Icon;
    }

    public void setIcon(String icon) {
        Icon = icon;
    }
}
