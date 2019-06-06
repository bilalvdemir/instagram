
package com.example.bilal.instagram.model.self;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("profile_picture")
    @Expose
    private String profilePicture;
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("bio")
    @Expose
    private String bio;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("is_business")
    @Expose
    private Boolean isBusiness;
    @SerializedName("counts")
    @Expose
    private Counts counts;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Data() {
    }

    /**
     * 
     * @param id
     * @param username
     * @param bio
     * @param website
     * @param profilePicture
     * @param counts
     * @param fullName
     * @param isBusiness
     */
    public Data(String id, String username, String profilePicture, String fullName, String bio, String website, Boolean isBusiness, Counts counts) {
        super();
        this.id = id;
        this.username = username;
        this.profilePicture = profilePicture;
        this.fullName = fullName;
        this.bio = bio;
        this.website = website;
        this.isBusiness = isBusiness;
        this.counts = counts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Boolean getIsBusiness() {
        return isBusiness;
    }

    public void setIsBusiness(Boolean isBusiness) {
        this.isBusiness = isBusiness;
    }

    public Counts getCounts() {
        return counts;
    }

    public void setCounts(Counts counts) {
        this.counts = counts;
    }



}
