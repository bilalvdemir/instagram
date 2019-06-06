
package com.example.bilal.instagram.model.media;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Caption {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("created_time")
    @Expose
    private String createdTime;
    @SerializedName("from")
    @Expose
    private From from;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Caption() {
    }

    /**
     * 
     * @param id
     * @param text
     * @param createdTime
     * @param from
     */
    public Caption(String id, String text, String createdTime, From from) {
        super();
        this.id = id;
        this.text = text;
        this.createdTime = createdTime;
        this.from = from;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public From getFrom() {
        return from;
    }

    public void setFrom(From from) {
        this.from = from;
    }


}
