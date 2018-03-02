package com.protutr.customlistviewdemo.model;

/**
 * Created by ravi on 3/2/2018.
 */

public class RowData {
    private String title,subtitle,version;
    private  int image;

    public RowData(String title, String subtitle, String version, int image) {
        this.title = title;
        this.subtitle = subtitle;
        this.version = version;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


}
