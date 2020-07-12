package com.TruDoc.Weather.data.network.pojo;

import java.io.Serializable;
import java.util.List;

public class Details implements Serializable {
    private String date;
    private String status;
    private String icon;
    private List<DetailsItem> lstItems;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<DetailsItem> getLstItems() {
        return lstItems;
    }

    public void setLstItems(List<DetailsItem> lstItems) {
        this.lstItems = lstItems;
    }
}
