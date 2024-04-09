package com.github.donaldwilson8.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Link {
    private String href;
    private String title;

    public String getHref() {
        return href;
    }

    public void setHref(String self) {
        this.href = self;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
