
package com.example.bilal.instagram.model.media;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MediaResponse {

    @SerializedName("pagination")
    @Expose
    private Object pagination;
    @SerializedName("data")
    @Expose
    private ArrayList<Data> data = null;
    @SerializedName("meta")
    @Expose
    private Meta meta;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MediaResponse() {
    }

    /**
     * 
     * @param data
     * @param pagination
     * @param meta
     */
    public MediaResponse(Object pagination, ArrayList<Data> data, Meta meta) {
        super();
        this.pagination = pagination;
        this.data = data;
        this.meta = meta;
    }

    public Object getPagination() {
        return pagination;
    }

    public void setPagination(Object pagination) {
        this.pagination = pagination;
    }

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

}
