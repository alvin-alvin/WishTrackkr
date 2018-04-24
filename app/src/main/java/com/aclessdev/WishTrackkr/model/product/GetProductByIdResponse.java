package com.aclessdev.WishTrackkr.model.product;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by AlvinTan on 14/03/18.
 */

public class GetProductByIdResponse extends RealmObject {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("product")
    @Expose
    private Product product;
//    @SerializedName("message")
//    @Expose
//    private Object message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

//    public Object getMessage() {
//        return message;
//    }
//
//    public void setMessage(Object message) {
//        this.message = message;
//    }
}
