/**
 * CreativeResource.java
 * Created at 2016-10-17
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 前台首页创意资源实体类
 */
public class CreativeResource implements Serializable{

	private static final long serialVersionUID = 1L;

	/** 创意资源id */
    private Long creativeResourceId;
    
    /** 用户id */
    private Long userId;
    
    /** 资源发布人名称 */
    private String publishName;
    
    /** 资源名称 */
    private String resourceName;
    
    /** 资源图片 */
    private String resourceImage;
    
    /** 资源图片名称 */
    private String resourceImageName;

	/** 资源数量 */
    private Integer resourceNumber;
    
    /** 资源描述 */
    private String resourceDescription;
    
    /** 资源演示地址 */
    private String showAddress;
    
    /** 资源附件地址 */
    private String resourceAttach;
    
    /** 资源附件名称 */
    private String resourceAttachName;
    
    /** 资源附件演示地址 */
    private String resourceAttachSee;
    
    /** 资源币种 */
    private Integer resourceCurrency;
    
    /** 资源价格 */
    private BigDecimal resourcePrice;
    
    /** 资源状态码 */
    private Integer resourceStatus;
    
    /** 资源状态值 */
    private String resourceStatusValue;
   
    /** 删除标志 */
    private Byte active;
    
    /** 发布时间 */
    private Date publishDatetime;
    
    /** 创意资源类型 */
    private String resourceType;
    
    /** 资源状态字符串数组 */
    private String[] resource;
    
    /**输入的多个Id*/
    private  int[] ids;
   
    /** 审核结果 */
    private String auditStatus;
    
    /** 购物车ID*/
    private Long shoppingCardId;
    
    /** 购买数量*/
    private Long shoppingNum;
    /** 1表示已经收藏，0表示未收藏*/
	private Byte isHouse;
    
    /** page */
    private int page;
    
    /** pageSize */
    private int pageSize;
    
	public Byte getIsHouse() {
		return isHouse;
	}
	public void setIsHouse(Byte isHouse) {
		this.isHouse = isHouse;
	}
	public int[] getIds() {
		return ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}

	public Long getCreativeResourceId() {
        return creativeResourceId;
    }

    public void setCreativeResourceId(Long creativeResourceId) {
        this.creativeResourceId = creativeResourceId;
    }    

    public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Integer getResourceNumber() {
        return resourceNumber;
    }

    public void setResourceNumber(Integer resourceNumber) {
        this.resourceNumber = resourceNumber;
    }

    public String getResourceDescription() {
        return resourceDescription;
    }

    public void setResourceDescription(String resourceDescription) {
        this.resourceDescription = resourceDescription;
    }

    public String getShowAddress() {
        return showAddress;
    }

    public void setShowAddress(String showAddress) {
        this.showAddress = showAddress;
    }

    public String getResourceAttach() {
        return resourceAttach;
    }

    public void setResourceAttach(String resourceAttach) {
        this.resourceAttach = resourceAttach;
    }

    public String getResourceAttachName() {
        return resourceAttachName;
    }

    public void setResourceAttachName(String resourceAttachName) {
        this.resourceAttachName = resourceAttachName;
    }

    public String getResourceAttachSee() {
		return resourceAttachSee;
	}

	public void setResourceAttachSee(String resourceAttachSee) {
		this.resourceAttachSee = resourceAttachSee;
	}

	public Integer getResourceCurrency() {
        return resourceCurrency;
    }

    public void setResourceCurrency(Integer resourceCurrency) {
        this.resourceCurrency = resourceCurrency;
    }

    public BigDecimal getResourcePrice() {
        return resourcePrice;
    }

    public void setResourcePrice(BigDecimal resourcePrice) {
        this.resourcePrice = resourcePrice;
    }

    public Byte getActive() {
		return active;
	}

	public void setActive(Byte active) {
		this.active = active;
	}

	public Integer getResourceStatus() {
		return resourceStatus;
	}

	public void setResourceStatus(Integer resourceStatus) {
		this.resourceStatus = resourceStatus;
	}

	public String getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(String resourceImage) {
        this.resourceImage = resourceImage;
    }
  
    
    public String getResourceImageName() {
		return resourceImageName;
	}

	public void setResourceImageName(String resourceImageName) {
		this.resourceImageName = resourceImageName;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Date getPublishDatetime() {
		return publishDatetime;
	}

	public void setPublishDatetime(Date publishDatetime) {
		this.publishDatetime = publishDatetime;
	}

	public String getPublishName() {
		return publishName;
	}

	public void setPublishName(String publishName) {
		this.publishName = publishName;
	}

	public String getResourceStatusValue() {
		return resourceStatusValue;
	}

	public void setResourceStatusValue(String resourceStatusValue) {
		this.resourceStatusValue = resourceStatusValue;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String[] getResource() {
		return resource;
	}

	public void setResource(String[] resource) {
		this.resource = resource;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public Long getShoppingCardId() {
		return shoppingCardId;
	}

	public void setShoppingCardId(Long shoppingCardId) {
		this.shoppingCardId = shoppingCardId;
	}

	public Long getShoppingNum() {
		return shoppingNum;
	}

	public void setShoppingNum(Long shoppingNum) {
		this.shoppingNum = shoppingNum;
	}

}
