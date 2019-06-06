
package com.example.bilal.instagram.model.media;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Videos {

    @SerializedName("standard_resolution")
    @Expose
    private Video standardResolution;
    @SerializedName("low_resolution")
    @Expose
    private Video lowResolution;
    @SerializedName("low_bandwidth")
    @Expose
    private Video lowBandwidth;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Videos() {
    }

    /**
     * 
     * @param lowBandwidth
     * @param lowResolution
     * @param standardResolution
     */
    public Videos(Video standardResolution, Video lowResolution, Video lowBandwidth) {
        super();
        this.standardResolution = standardResolution;
        this.lowResolution = lowResolution;
        this.lowBandwidth = lowBandwidth;
    }

    public Video getStandardResolution() {
        return standardResolution;
    }

    public void setStandardResolution(Video standardResolution) {
        this.standardResolution = standardResolution;
    }

    public Video getLowResolution() {
        return lowResolution;
    }

    public void setLowResolution(Video lowResolution) {
        this.lowResolution = lowResolution;
    }

    public Video getLowBandwidth() {
        return lowBandwidth;
    }

    public void setLowBandwidth(Video lowBandwidth) {
        this.lowBandwidth = lowBandwidth;
    }



}
