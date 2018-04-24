package com.aclessdev.WishTrackkr.model.product;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by AlvinTan on 14/03/18.
 */

public class Specs extends RealmObject {
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("type")
    @Expose
    private String type;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
