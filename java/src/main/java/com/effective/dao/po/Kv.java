/**
 * Copyright (c) 2019, Cana and/or its affiliates. All rights reserved.
 */
package com.effective.dao.po;

import java.io.Serializable;
import java.util.Date;

public class Kv implements Serializable {
    /**
     * 主键(自增ID)
     */
    private Long id;

    /**
     * key
     */
    private String k;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModify;

    /**
     * value
     */
    private String v;

    private static final long serialVersionUID = 1L;

    /**
     * 主键(自增ID)
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键(自增ID)
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * key
     */
    public String getK() {
        return k;
    }

    /**
     * key
     */
    public void setK(String k) {
        this.k = k == null ? null : k.trim();
    }

    /**
     * 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 修改时间
     */
    public Date getGmtModify() {
        return gmtModify;
    }

    /**
     * 修改时间
     */
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    /**
     * value
     */
    public String getV() {
        return v;
    }

    /**
     * value
     */
    public void setV(String v) {
        this.v = v == null ? null : v.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Kv other = (Kv) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getK() == null ? other.getK() == null : this.getK().equals(other.getK()))
                && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
                && (this.getGmtModify() == null ? other.getGmtModify() == null : this.getGmtModify().equals(other.getGmtModify()))
                && (this.getV() == null ? other.getV() == null : this.getV().equals(other.getV()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getK() == null) ? 0 : getK().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModify() == null) ? 0 : getGmtModify().hashCode());
        result = prime * result + ((getV() == null) ? 0 : getV().hashCode());
        return result;
    }
}