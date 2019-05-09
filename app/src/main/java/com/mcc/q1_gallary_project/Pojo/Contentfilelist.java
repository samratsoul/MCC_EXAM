package com.mcc.q1_gallary_project.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Contentfilelist {

    @SerializedName("contentfilelist")
    @Expose
    private List<Contentfilelist_> contentfilelist = null;

    public List<Contentfilelist_> getContentfilelist() {
        return contentfilelist;
    }

    public void setContentfilelist(List<Contentfilelist_> contentfilelist) {
        this.contentfilelist = contentfilelist;
    }
}
