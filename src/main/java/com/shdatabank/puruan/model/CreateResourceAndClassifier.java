package com.shdatabank.puruan.model;

import java.util.List;

/**
 * 创意资源对象与创意资源分类对象集合封装类
 * 用于充当创意资源的参数对象
 * @author zhoujunlei
 *
 */
public class CreateResourceAndClassifier {
	//创意资源对象
	private  CreativeResource creativeResource;
	//创意资源分类对象集合
	private  List<CreativeResourceClassifier> creativeResourceClassifierList;
	//区别保存于发布的标志：保存为0，发布为1
	private String flg;

	public CreativeResource getCreativeResource() {
		return creativeResource;
	}

	public void setCreativeResource(CreativeResource creativeResource) {
		this.creativeResource = creativeResource;
	}

	public List<CreativeResourceClassifier> getCreativeResourceClassifierList() {
		return creativeResourceClassifierList;
	}

	public void setCreativeResourceClassifierList(List<CreativeResourceClassifier> creativeResourceClassifierList) {
		this.creativeResourceClassifierList = creativeResourceClassifierList;
	}

	public String getFlg() {
		return flg;
	}

	public void setFlg(String flg) {
		this.flg = flg;
	}



}
