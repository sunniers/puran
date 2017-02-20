package com.shdatabank.puruan.model;

import java.io.Serializable;
import java.util.List;

public class ShoppingCart implements Serializable{

	private static final long serialVersionUID = 1L;
	/** 购物车id */
	private Long shoppingCartId;
	/** 用户id */
	private Long userId;
	/** 物品类型 */
	private Integer goodsType;
	/** 物品id */
	private Long goodsId;
	/** 物品数量 */
	private int goodsNumber;
	/** 删除标致*/
	private Byte active;
	
	
	/** 创意资源实体类 */
    private List<CreativeResource> creativeResources;

	public Long getShoppingCartId() {
		return shoppingCartId;
	}

	public void setShoppingCartId(Long shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public Integer getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public int getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public List<CreativeResource> getCreativeResources() {
		return creativeResources;
	}

	public void setCreativeResources(List<CreativeResource> creativeResources) {
		this.creativeResources = creativeResources;
	}

	public Byte getActive() {
		return active;
	}

	public void setActive(Byte active) {
		this.active = active;
	}

}
