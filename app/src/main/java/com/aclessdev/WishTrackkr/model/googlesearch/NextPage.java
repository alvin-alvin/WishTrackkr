package com.aclessdev.WishTrackkr.model.googlesearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by AlvinTan on 08/04/18.
 */

public class NextPage {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("totalResults")
    @Expose
    private String totalResults;
    @SerializedName("searchTerms")
    @Expose
    private String searchTerms;
    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("startIndex")
    @Expose
    private int startIndex;
    @SerializedName("inputEncoding")
    @Expose
    private String inputEncoding;
    @SerializedName("outputEncoding")
    @Expose
    private String outputEncoding;
    @SerializedName("safe")
    @Expose
    private String safe;
    @SerializedName("cx")
    @Expose
    private String cx;
    @SerializedName("searchType")
    @Expose
    private String searchType;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getSearchTerms() {
        return searchTerms;
    }

    public void setSearchTerms(String searchTerms) {
        this.searchTerms = searchTerms;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public String getInputEncoding() {
        return inputEncoding;
    }

    public void setInputEncoding(String inputEncoding) {
        this.inputEncoding = inputEncoding;
    }

    public String getOutputEncoding() {
        return outputEncoding;
    }

    public void setOutputEncoding(String outputEncoding) {
        this.outputEncoding = outputEncoding;
    }

    public String getSafe() {
        return safe;
    }

    public void setSafe(String safe) {
        this.safe = safe;
    }

    public String getCx() {
        return cx;
    }

    public void setCx(String cx) {
        this.cx = cx;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }
}
