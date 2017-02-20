package com.shdatabank.puruan.model;

import java.util.List;
/**
 * 融资与融资类型集合对象
 * 用作融资发布接受参数
 * @author Administrator
 *
 */
public class FancingAndClassifierList {

	/**融资对象**/
	private Fancing fancing;
	
	/**融资分类对象集合**/
	private List<FancingClassifier> fancingClassifiers;

	public Fancing getFancing() {
		return fancing;
	}

	public void setFancing(Fancing fancing) {
		this.fancing = fancing;
	}

	public List<FancingClassifier> getFancingClassifiers() {
		return fancingClassifiers;
	}

	public void setFancingClassifiers(List<FancingClassifier> fancingClassifiers) {
		this.fancingClassifiers = fancingClassifiers;
	}
}
