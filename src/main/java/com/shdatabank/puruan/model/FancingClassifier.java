package com.shdatabank.puruan.model;
/**
 * 融资分类实体对象
 * @author Administrator
 *
 */
public class FancingClassifier {

	/**融资分类ID**/
	private Integer fancingClassifierId;
	/**融资ID**/
	private Long fancingId;
	/**融资分类值**/
	private Integer fancingClassifierValue;
	
	public Integer getFancingClassifierId() {
		return fancingClassifierId;
	}
	public void setFancingClassifierId(Integer fancingClassifierId) {
		this.fancingClassifierId = fancingClassifierId;
	}
	public Long getFancingId() {
		return fancingId;
	}
	public void setFancingId(Long fancingId) {
		this.fancingId = fancingId;
	}
	public Integer getFancingClassifierValue() {
		return fancingClassifierValue;
	}
	public void setFancingClassifierValue(Integer fancingClassifierValue) {
		this.fancingClassifierValue = fancingClassifierValue;
	}
}
