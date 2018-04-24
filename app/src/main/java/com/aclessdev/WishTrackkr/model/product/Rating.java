package com.aclessdev.WishTrackkr.model.product;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by AlvinTan on 14/03/18.
 */

public class Rating extends RealmObject {
    @SerializedName("average_rate")
    @Expose
    private float averageRate;
    @SerializedName("user_count")
    @Expose
    private int userCount;

    public float getAverageRate() {
        return averageRate;
    }

    public void setAverageRate(int averageRate) {
        this.averageRate = averageRate;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }
}
