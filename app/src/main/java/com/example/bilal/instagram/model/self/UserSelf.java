
package com.example.bilal.instagram.model.self;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserSelf {

    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("meta")
    @Expose
    private Meta meta;

    /**
     * No args constructor for use in serialization
     * 
     */
    public UserSelf() {
    }

    /**
     * 
     * @param data
     * @param meta
     */
    public UserSelf(Data data, Meta meta) {
        super();
        this.data = data;
        this.meta = meta;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }



}
