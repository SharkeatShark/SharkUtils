package com.shark;

import java.io.Serializable;
import java.util.Date;

public class IqProduct implements Serializable {
    private Integer id;

    private String productId;

    private String productCode;

    private String productName;

    private String productMainCover;

    private String productFeature;

    private String price;

    private String color;

    private String texture;

    private String size;

    private Integer state;

    private String style1;

    private Date createTime;

    private String sizeList;

    private String productTag;

    private String intro;

    private Integer sort;

    private Integer effective;

    private Long timestamp;

    private Integer fresh;

    private String sku;

    private String sellPoint;

    private Integer notarize;

    private Long timestampofficial;

    private Long timestampspecial;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductMainCover() {
        return productMainCover;
    }

    public void setProductMainCover(String productMainCover) {
        this.productMainCover = productMainCover == null ? null : productMainCover.trim();
    }

    public String getProductFeature() {
        return productFeature;
    }

    public void setProductFeature(String productFeature) {
        this.productFeature = productFeature == null ? null : productFeature.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture == null ? null : texture.trim();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getStyle1() {
        return style1;
    }

    public void setStyle1(String style1) {
        this.style1 = style1 == null ? null : style1.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSizeList() {
        return sizeList;
    }

    public void setSizeList(String sizeList) {
        this.sizeList = sizeList == null ? null : sizeList.trim();
    }

    public String getProductTag() {
        return productTag;
    }

    public void setProductTag(String productTag) {
        this.productTag = productTag == null ? null : productTag.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getEffective() {
        return effective;
    }

    public void setEffective(Integer effective) {
        this.effective = effective;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getFresh() {
        return fresh;
    }

    public void setFresh(Integer fresh) {
        this.fresh = fresh;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku == null ? null : sku.trim();
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint == null ? null : sellPoint.trim();
    }

    public Integer getNotarize() {
        return notarize;
    }

    public void setNotarize(Integer notarize) {
        this.notarize = notarize;
    }

    public Long getTimestampofficial() {
        return timestampofficial;
    }

    public void setTimestampofficial(Long timestampofficial) {
        this.timestampofficial = timestampofficial;
    }

    public Long getTimestampspecial() {
        return timestampspecial;
    }

    public void setTimestampspecial(Long timestampspecial) {
        this.timestampspecial = timestampspecial;
    }
}