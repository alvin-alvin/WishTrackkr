package com.aclessdev.WishTrackkr.model.product;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by AlvinTan on 14/03/18.
 */

public class Product extends RealmObject {

    public Product() {
    }

    public Product(String productLink, int price, String id, String url, String name, RealmList<String> images) {
        this.productLink = productLink;
        this.price = price;
        this.id = id;
        this.url = url;
        this.name = name;
        this.images = images;
    }

    public String getProductLink() {
        return productLink;
    }

    public void setProductLink(String productLink) {
        this.productLink = productLink;
    }

    String productLink;

    @SerializedName("deal_info")
    @Expose
    private DealInfo dealInfo;
    @SerializedName("deal_request_state")
    @Expose
    private String dealRequestState;
    @SerializedName("price")
    @Expose
    private int price;
    @SerializedName("category_id")
    @Expose
    private int categoryId;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("category_structure")
    @Expose
    private RealmList<String> categoryStructure = null;
    @SerializedName("seller_username")
    @Expose
    private String sellerUsername;
    @SerializedName("seller_name")
    @Expose
    private String sellerName;
    @SerializedName("seller_id")
    @Expose
    private int sellerId;
    @SerializedName("seller_avatar")
    @Expose
    private String sellerAvatar;
    @SerializedName("seller_level")
    @Expose
    private String sellerLevel;
    @SerializedName("seller_level_badge_url")
    @Expose
    private String sellerLevelBadgeUrl;
    @SerializedName("seller_delivery_time")
    @Expose
    private String sellerDeliveryTime;
    @SerializedName("seller_positive_feedback")
    @Expose
    private int sellerPositiveFeedback;
    @SerializedName("seller_negative_feedback")
    @Expose
    private int sellerNegativeFeedback;
    @SerializedName("seller_term_condition")
    @Expose
    private String sellerTermCondition;
//    @SerializedName("seller_alert")
//    @Expose
//    private Object sellerAlert;
    @SerializedName("for_sale")
    @Expose
    private boolean forSale;
//    @SerializedName("state_description")
//    @Expose
//    private List<Object> stateDescription = null;
    @SerializedName("premium_account")
    @Expose
    private boolean premiumAccount;
    @SerializedName("brand")
    @Expose
    private boolean brand;
    @SerializedName("top_merchant")
    @Expose
    private boolean topMerchant;

    @SerializedName("last_order_schedule")
    @Expose
    private LastOrderSchedule lastOrderSchedule;

    @SerializedName("seller_voucher")
    @Expose
    private SellerVoucher sellerVoucher;

    @SerializedName("waiting_payment")
    @Expose
    private int waitingPayment;
    @SerializedName("sold_count")
    @Expose
    private int soldCount;
    @SerializedName("specs")
    @Expose
    private Specs specs;
    @SerializedName("force_insurance")
    @Expose
    private boolean forceInsurance;
//    @SerializedName("free_shipping_coverage")
//    @Expose
//    private List<Object> freeShippingCoverage = null;
    @SerializedName("video_url")
    @Expose
    private String videoUrl;
    @SerializedName("sla_display")
    @Expose
    private int slaDisplay;
    @SerializedName("sla_type")
    @Expose
    private String slaType;
    @SerializedName("assurance")
    @Expose
    private boolean assurance;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("active")
    @Expose
    private boolean active;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("province")
    @Expose
    private String province;
    @SerializedName("weight")
    @Expose
    private int weight;
    @SerializedName("image_ids")
    @Expose
    private RealmList<String> imageIds = null;
    @SerializedName("new_image_ids")
    @Expose
    private RealmList<String> newImageIds = null;
    @SerializedName("images")
    @Expose
    private RealmList<String> images = null;
    @SerializedName("small_images")
    @Expose
    private RealmList<String> smallImages = null;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("condition")
    @Expose
    private String condition;
    @SerializedName("stock")
    @Expose
    private int stock;
    @SerializedName("favorited")
    @Expose
    private boolean favorited;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
//    @SerializedName("product_sin")
//    @Expose
//    private List<Object> productSin = null;
    @SerializedName("rating")
    @Expose
    private Rating rating;
    @SerializedName("current_variant_name")
    @Expose
    private String currentVariantName;
    @SerializedName("current_product_sku_id")
    @Expose
    private int currentProductSkuId;
//    @SerializedName("product_sku")
//    @Expose
//    private List<Object> productSku = null;
//    @SerializedName("options")
//    @Expose
//    private List<Object> options = null;
//    @SerializedName("alternative_image")
//    @Expose
//    private Object alternativeImage;
    @SerializedName("min_quantity")
    @Expose
    private int minQuantity;
    @SerializedName("max_quantity")
    @Expose
    private int maxQuantity;
    @SerializedName("has_bundling")
    @Expose
    private boolean hasBundling;
    @SerializedName("on_bundling")
    @Expose
    private boolean onBundling;
    @SerializedName("courier")
    @Expose
    private RealmList<String> courier = null;
    @SerializedName("interest_count")
    @Expose
    private int interestCount;
    @SerializedName("last_relist_at")
    @Expose
    private String lastRelistAt;
    @SerializedName("view_count")
    @Expose
    private int viewCount;

    public DealInfo getDealInfo() {
        return dealInfo;
    }

    public void setDealInfo(DealInfo dealInfo) {
        this.dealInfo = dealInfo;
    }

    public String getDealRequestState() {
        return dealRequestState;
    }

    public void setDealRequestState(String dealRequestState) {
        this.dealRequestState = dealRequestState;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getCategoryStructure() {
        return categoryStructure;
    }

    public void setCategoryStructure(RealmList<String> categoryStructure) {
        this.categoryStructure = categoryStructure;
    }

    public String getSellerUsername() {
        return sellerUsername;
    }

    public void setSellerUsername(String sellerUsername) {
        this.sellerUsername = sellerUsername;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerAvatar() {
        return sellerAvatar;
    }

    public void setSellerAvatar(String sellerAvatar) {
        this.sellerAvatar = sellerAvatar;
    }

    public String getSellerLevel() {
        return sellerLevel;
    }

    public void setSellerLevel(String sellerLevel) {
        this.sellerLevel = sellerLevel;
    }

    public String getSellerLevelBadgeUrl() {
        return sellerLevelBadgeUrl;
    }

    public void setSellerLevelBadgeUrl(String sellerLevelBadgeUrl) {
        this.sellerLevelBadgeUrl = sellerLevelBadgeUrl;
    }

    public String getSellerDeliveryTime() {
        return sellerDeliveryTime;
    }

    public void setSellerDeliveryTime(String sellerDeliveryTime) {
        this.sellerDeliveryTime = sellerDeliveryTime;
    }

    public int getSellerPositiveFeedback() {
        return sellerPositiveFeedback;
    }

    public void setSellerPositiveFeedback(int sellerPositiveFeedback) {
        this.sellerPositiveFeedback = sellerPositiveFeedback;
    }

    public int getSellerNegativeFeedback() {
        return sellerNegativeFeedback;
    }

    public void setSellerNegativeFeedback(int sellerNegativeFeedback) {
        this.sellerNegativeFeedback = sellerNegativeFeedback;
    }

    public String getSellerTermCondition() {
        return sellerTermCondition;
    }

    public void setSellerTermCondition(String sellerTermCondition) {
        this.sellerTermCondition = sellerTermCondition;
    }

//    public Object getSellerAlert() {
//        return sellerAlert;
//    }
//
//    public void setSellerAlert(Object sellerAlert) {
//        this.sellerAlert = sellerAlert;
//    }

    public boolean isForSale() {
        return forSale;
    }

    public void setForSale(boolean forSale) {
        this.forSale = forSale;
    }

//    public List<Object> getStateDescription() {
//        return stateDescription;
//    }
//
//    public void setStateDescription(List<Object> stateDescription) {
//        this.stateDescription = stateDescription;
//    }

    public boolean isPremiumAccount() {
        return premiumAccount;
    }

    public void setPremiumAccount(boolean premiumAccount) {
        this.premiumAccount = premiumAccount;
    }

    public boolean isBrand() {
        return brand;
    }

    public void setBrand(boolean brand) {
        this.brand = brand;
    }

    public boolean isTopMerchant() {
        return topMerchant;
    }

    public void setTopMerchant(boolean topMerchant) {
        this.topMerchant = topMerchant;
    }

//    public LastOrderSchedule getLastOrderSchedule() {
//        return lastOrderSchedule;
//    }
//
//    public void setLastOrderSchedule(LastOrderSchedule lastOrderSchedule) {
//        this.lastOrderSchedule = lastOrderSchedule;
//    }
//
//    public SellerVoucher getSellerVoucher() {
//        return sellerVoucher;
//    }
//
//    public void setSellerVoucher(SellerVoucher sellerVoucher) {
//        this.sellerVoucher = sellerVoucher;
//    }

    public int getWaitingPayment() {
        return waitingPayment;
    }

    public void setWaitingPayment(int waitingPayment) {
        this.waitingPayment = waitingPayment;
    }

    public int getSoldCount() {
        return soldCount;
    }

    public void setSoldCount(int soldCount) {
        this.soldCount = soldCount;
    }

    public Specs getSpecs() {
        return specs;
    }

    public void setSpecs(Specs specs) {
        this.specs = specs;
    }

    public boolean isForceInsurance() {
        return forceInsurance;
    }

    public void setForceInsurance(boolean forceInsurance) {
        this.forceInsurance = forceInsurance;
    }

//    public List<Object> getFreeShippingCoverage() {
//        return freeShippingCoverage;
//    }
//
//    public void setFreeShippingCoverage(List<Object> freeShippingCoverage) {
//        this.freeShippingCoverage = freeShippingCoverage;
//    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public int getSlaDisplay() {
        return slaDisplay;
    }

    public void setSlaDisplay(int slaDisplay) {
        this.slaDisplay = slaDisplay;
    }

    public String getSlaType() {
        return slaType;
    }

    public void setSlaType(String slaType) {
        this.slaType = slaType;
    }

    public boolean isAssurance() {
        return assurance;
    }

    public void setAssurance(boolean assurance) {
        this.assurance = assurance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<String> getImageIds() {
        return imageIds;
    }

    public void setImageIds(RealmList<String> imageIds) {
        this.imageIds = imageIds;
    }

    public List<String> getNewImageIds() {
        return newImageIds;
    }

    public void setNewImageIds(RealmList<String> newImageIds) {
        this.newImageIds = newImageIds;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(RealmList<String> images) {
        this.images = images;
    }

    public List<String> getSmallImages() {
        return smallImages;
    }

    public void setSmallImages(RealmList<String> smallImages) {
        this.smallImages = smallImages;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

//    public List<Object> getProductSin() {
//        return productSin;
//    }
//
//    public void setProductSin(List<Object> productSin) {
//        this.productSin = productSin;
//    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getCurrentVariantName() {
        return currentVariantName;
    }

    public void setCurrentVariantName(String currentVariantName) {
        this.currentVariantName = currentVariantName;
    }

    public int getCurrentProductSkuId() {
        return currentProductSkuId;
    }

    public void setCurrentProductSkuId(int currentProductSkuId) {
        this.currentProductSkuId = currentProductSkuId;
    }

//    public List<Object> getProductSku() {
//        return productSku;
//    }
//
//    public void setProductSku(List<Object> productSku) {
//        this.productSku = productSku;
//    }
//
//    public List<Object> getOptions() {
//        return options;
//    }
//
//    public void setOptions(List<Object> options) {
//        this.options = options;
//    }
//
//    public Object getAlternativeImage() {
//        return alternativeImage;
//    }
//
//    public void setAlternativeImage(Object alternativeImage) {
//        this.alternativeImage = alternativeImage;
//    }

    public int getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(int minQuantity) {
        this.minQuantity = minQuantity;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    public boolean isHasBundling() {
        return hasBundling;
    }

    public void setHasBundling(boolean hasBundling) {
        this.hasBundling = hasBundling;
    }

    public boolean isOnBundling() {
        return onBundling;
    }

    public void setOnBundling(boolean onBundling) {
        this.onBundling = onBundling;
    }

    public List<String> getCourier() {
        return courier;
    }

    public void setCourier(RealmList<String> courier) {
        this.courier = courier;
    }

    public int getInterestCount() {
        return interestCount;
    }

    public void setInterestCount(int interestCount) {
        this.interestCount = interestCount;
    }

    public String getLastRelistAt() {
        return lastRelistAt;
    }

    public void setLastRelistAt(String lastRelistAt) {
        this.lastRelistAt = lastRelistAt;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }
}
