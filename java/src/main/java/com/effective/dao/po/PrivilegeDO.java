/**
 * Copyright (c) 2019, Cana and/or its affiliates. All rights reserved.
 */
package com.effective.dao.po;

import java.io.Serializable;
import java.util.Date;

public class PrivilegeDO implements Serializable {
    /**
     *主键(自增ID)
     */
    private Long id;

    /**
     *权限id
     */
    private String privilegeUuid;

    /**
     *权限名称
     */
    private String privilegeName;

    /**
     *权限显示顺序(小数靠上)
     */
    private Integer privilegeSort;

    /**
     *父级权限编号
     */
    private String parentPrivilegeUuid;

    /**
     *是否为菜单
     */
    private Boolean isMenu;

    /**
     *菜单或按钮关联的请求地址
     */
    private String route;

    /**
     *icon
     */
    private String icon;

    /**
     *创建时间
     */
    private Date gmtCreate;

    /**
     *修改时间
     */
    private Date gmtModify;

    private static final long serialVersionUID = 1L;

    /**
     *主键(自增ID)
     */
    public Long getId() {
        return id;
    }

    /**
     *主键(自增ID)
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *权限id
     */
    public String getPrivilegeUuid() {
        return privilegeUuid;
    }

    /**
     *权限id
     */
    public void setPrivilegeUuid(String privilegeUuid) {
        this.privilegeUuid = privilegeUuid == null ? null : privilegeUuid.trim();
    }

    /**
     *权限名称
     */
    public String getPrivilegeName() {
        return privilegeName;
    }

    /**
     *权限名称
     */
    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName == null ? null : privilegeName.trim();
    }

    /**
     *权限显示顺序(小数靠上)
     */
    public Integer getPrivilegeSort() {
        return privilegeSort;
    }

    /**
     *权限显示顺序(小数靠上)
     */
    public void setPrivilegeSort(Integer privilegeSort) {
        this.privilegeSort = privilegeSort;
    }

    /**
     *父级权限编号
     */
    public String getParentPrivilegeUuid() {
        return parentPrivilegeUuid;
    }

    /**
     *父级权限编号
     */
    public void setParentPrivilegeUuid(String parentPrivilegeUuid) {
        this.parentPrivilegeUuid = parentPrivilegeUuid == null ? null : parentPrivilegeUuid.trim();
    }

    /**
     *是否为菜单
     */
    public Boolean getIsMenu() {
        return isMenu;
    }

    /**
     *是否为菜单
     */
    public void setIsMenu(Boolean isMenu) {
        this.isMenu = isMenu;
    }

    /**
     *菜单或按钮关联的请求地址
     */
    public String getRoute() {
        return route;
    }

    /**
     *菜单或按钮关联的请求地址
     */
    public void setRoute(String route) {
        this.route = route == null ? null : route.trim();
    }

    /**
     *icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     *icon
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     *创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     *创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     *修改时间
     */
    public Date getGmtModify() {
        return gmtModify;
    }

    /**
     *修改时间
     */
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
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
        PrivilegeDO other = (PrivilegeDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPrivilegeUuid() == null ? other.getPrivilegeUuid() == null : this.getPrivilegeUuid().equals(other.getPrivilegeUuid()))
            && (this.getPrivilegeName() == null ? other.getPrivilegeName() == null : this.getPrivilegeName().equals(other.getPrivilegeName()))
            && (this.getPrivilegeSort() == null ? other.getPrivilegeSort() == null : this.getPrivilegeSort().equals(other.getPrivilegeSort()))
            && (this.getParentPrivilegeUuid() == null ? other.getParentPrivilegeUuid() == null : this.getParentPrivilegeUuid().equals(other.getParentPrivilegeUuid()))
            && (this.getIsMenu() == null ? other.getIsMenu() == null : this.getIsMenu().equals(other.getIsMenu()))
            && (this.getRoute() == null ? other.getRoute() == null : this.getRoute().equals(other.getRoute()))
            && (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModify() == null ? other.getGmtModify() == null : this.getGmtModify().equals(other.getGmtModify()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPrivilegeUuid() == null) ? 0 : getPrivilegeUuid().hashCode());
        result = prime * result + ((getPrivilegeName() == null) ? 0 : getPrivilegeName().hashCode());
        result = prime * result + ((getPrivilegeSort() == null) ? 0 : getPrivilegeSort().hashCode());
        result = prime * result + ((getParentPrivilegeUuid() == null) ? 0 : getParentPrivilegeUuid().hashCode());
        result = prime * result + ((getIsMenu() == null) ? 0 : getIsMenu().hashCode());
        result = prime * result + ((getRoute() == null) ? 0 : getRoute().hashCode());
        result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModify() == null) ? 0 : getGmtModify().hashCode());
        return result;
    }
}