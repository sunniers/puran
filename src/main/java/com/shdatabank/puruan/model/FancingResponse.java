package com.shdatabank.puruan.model;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * 融资分类集合与融资方式集合实体
 * @author Administrator
 *
 */
public class FancingResponse {
	
	//融资分类集合
	private List<Dictionarydata> allFacningClass=new ArrayList<Dictionarydata>();
	
	//融资方式集合
	private List<Dictionarydata> allFacningWay=new ArrayList<Dictionarydata>();

	public List<Dictionarydata> getAllFacningClass() {
		return allFacningClass;
	}

	public void setAllFacningClass(List<Dictionarydata> allFacningClass) {
		this.allFacningClass = allFacningClass;
	}

	public List<Dictionarydata> getAllFacningWay() {
		return allFacningWay;
	}

	public void setAllFacningWay(List<Dictionarydata> allFacningWay) {
		this.allFacningWay = allFacningWay;
	}


}
