package com.shdatabank.puruan.model;

public class MyFavorite {

	/** 资源id */
	private Long id;
	/** 需求类型 */
	private String type;
	/** 资源名称 */
	private String name;
	/** 资源描述 */
	private String description;
	/** 交易价格 */
	private double price;
	/** 用户ID */
	private Long userId;
	
	/**需求状态*/
	private String status;
	
	/** 页码 */
	private int page;
	/** 每页显示数量 */
	private int pageSize;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
