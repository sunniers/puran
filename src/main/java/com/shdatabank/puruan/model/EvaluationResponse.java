package com.shdatabank.puruan.model;

import java.util.ArrayList;
import java.util.List;
/**
 * 申请评估返回申请人信息
 */
public class EvaluationResponse {

	/** 项目列表*/
	private List<ListModel> ProjectList=new ArrayList<ListModel>();
	/** 申请人*/
	private String applyPerson;
	
	public List<ListModel> getProjectList() {
		return ProjectList;
	}
	public void setProjectList(List<ListModel> projectList) {
		ProjectList = projectList;
	}
	public String getApplyPerson() {
		return applyPerson;
	}
	public void setApplyPerson(String applyPerson) {
		this.applyPerson = applyPerson;
	}
}
