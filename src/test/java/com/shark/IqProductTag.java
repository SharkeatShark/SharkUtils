package com.shark;

import java.io.Serializable;

public class IqProductTag implements Serializable {
    private Integer id;

    private String name;

    private Integer level;

    private String synonym;

    private String nameOr;

    private String nameAnd;

    private String nameNot;

    private Integer sort;

    private Integer count;

    private String pinyin;

    private Integer level1;

    private Integer purpose;

    private String viewTag;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getSynonym() {
        return synonym;
    }

    public void setSynonym(String synonym) {
        this.synonym = synonym == null ? null : synonym.trim();
    }

    public String getNameOr() {
        return nameOr;
    }

    public void setNameOr(String nameOr) {
        this.nameOr = nameOr == null ? null : nameOr.trim();
    }

    public String getNameAnd() {
        return nameAnd;
    }

    public void setNameAnd(String nameAnd) {
        this.nameAnd = nameAnd == null ? null : nameAnd.trim();
    }

    public String getNameNot() {
        return nameNot;
    }

    public void setNameNot(String nameNot) {
        this.nameNot = nameNot == null ? null : nameNot.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin == null ? null : pinyin.trim();
    }

    public Integer getLevel1() {
        return level1;
    }

    public void setLevel1(Integer level1) {
        this.level1 = level1;
    }

    public Integer getPurpose() {
        return purpose;
    }

    public void setPurpose(Integer purpose) {
        this.purpose = purpose;
    }

    public String getViewTag() {
        return viewTag;
    }

    public void setViewTag(String viewTag) {
        this.viewTag = viewTag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IqProductTag)) return false;
        IqProductTag that = (IqProductTag) o;
        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getLevel() != null ? getLevel().hashCode() : 0);
        result = 31 * result + (getSynonym() != null ? getSynonym().hashCode() : 0);
        result = 31 * result + (getNameOr() != null ? getNameOr().hashCode() : 0);
        result = 31 * result + (getNameAnd() != null ? getNameAnd().hashCode() : 0);
        result = 31 * result + (getNameNot() != null ? getNameNot().hashCode() : 0);
        result = 31 * result + (getSort() != null ? getSort().hashCode() : 0);
        result = 31 * result + (getCount() != null ? getCount().hashCode() : 0);
        result = 31 * result + (getPinyin() != null ? getPinyin().hashCode() : 0);
        result = 31 * result + (getLevel1() != null ? getLevel1().hashCode() : 0);
        result = 31 * result + (getPurpose() != null ? getPurpose().hashCode() : 0);
        result = 31 * result + (getViewTag() != null ? getViewTag().hashCode() : 0);
        return result;
    }

}