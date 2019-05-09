package com.mcc.q1_gallary_project.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contentfilelist_ {

    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Details")
    @Expose
    private String details;
    @SerializedName("IMG")
    @Expose
    private String iMG;
    @SerializedName("IMGW")
    @Expose
    private String iMGW;
    @SerializedName("AUDIO")
    @Expose
    private String aUDIO;
    @SerializedName("VIDEO")
    @Expose
    private String vIDEO;
    @SerializedName("FILE")
    @Expose
    private String fILE;
    @SerializedName("YT")
    @Expose
    private String yT;
    @SerializedName("Entry")
    @Expose
    private String entry;
    @SerializedName("LastUpdated")
    @Expose
    private String lastUpdated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getIMG() {
        return iMG;
    }

    public void setIMG(String iMG) {
        this.iMG = iMG;
    }

    public String getIMGW() {
        return iMGW;
    }

    public void setIMGW(String iMGW) {
        this.iMGW = iMGW;
    }

    public String getAUDIO() {
        return aUDIO;
    }

    public void setAUDIO(String aUDIO) {
        this.aUDIO = aUDIO;
    }

    public String getVIDEO() {
        return vIDEO;
    }

    public void setVIDEO(String vIDEO) {
        this.vIDEO = vIDEO;
    }

    public String getFILE() {
        return fILE;
    }

    public void setFILE(String fILE) {
        this.fILE = fILE;
    }

    public String getYT() {
        return yT;
    }

    public void setYT(String yT) {
        this.yT = yT;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}
