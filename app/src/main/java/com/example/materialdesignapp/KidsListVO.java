package com.example.materialdesignapp;

public class KidsListVO {
    private String name;
    private int url;

    public KidsListVO(String name, int url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUrl() {
        return url;
    }

    public void setUrl(int url) {
        this.url = url;
    }
}
