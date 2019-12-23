package com.androiddevs.mutlipleviewrecyclerview;

public class ImageData {

    private String title;
    private String description;
    private int resource;

    public ImageData(String title, String description, int resource) {
        this.title = title;
        this.description = description;
        this.resource = resource;
    }

    public String getTitle() { return title; }

    public String getDescription() { return description; }

    public int getResource() { return resource; }
}
