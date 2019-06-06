
package com.example.bilal.instagram.model.self;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Counts {

    @SerializedName("media")
    @Expose
    private Integer media;
    @SerializedName("follows")
    @Expose
    private Integer follows;
    @SerializedName("followed_by")
    @Expose
    private Integer followedBy;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Counts() {
    }

    /**
     * 
     * @param follows
     * @param followedBy
     * @param media
     */
    public Counts(Integer media, Integer follows, Integer followedBy) {
        super();
        this.media = media;
        this.follows = follows;
        this.followedBy = followedBy;
    }

    public Integer getMedia() {
        return media;
    }

    public void setMedia(Integer media) {
        this.media = media;
    }

    public Integer getFollows() {
        return follows;
    }

    public void setFollows(Integer follows) {
        this.follows = follows;
    }

    public Integer getFollowedBy() {
        return followedBy;
    }

    public void setFollowedBy(Integer followedBy) {
        this.followedBy = followedBy;
    }



}
