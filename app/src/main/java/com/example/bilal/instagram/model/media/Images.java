
package com.example.bilal.instagram.model.media;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Images {

    @SerializedName("thumbnail")
    @Expose
    private Image thumbnail;
    @SerializedName("low_resolution")
    @Expose
    private Image lowResolution;
    @SerializedName("standard_resolution")
    @Expose
    private Image standardResolution;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Images() {
    }

    /**
     * 
     * @param thumbnail
     * @param lowResolution
     * @param standardResolution
     */
    public Images(Image thumbnail, Image lowResolution, Image standardResolution) {
        super();
        this.thumbnail = thumbnail;
        this.lowResolution = lowResolution;
        this.standardResolution = standardResolution;
    }

    public Image getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Image thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Image getLowResolution() {
        return lowResolution;
    }

    public void setLowResolution(Image lowResolution) {
        this.lowResolution = lowResolution;
    }

    public Image getStandardResolution() {
        return standardResolution;
    }

    public void setStandardResolution(Image standardResolution) {
        this.standardResolution = standardResolution;
    }


}
