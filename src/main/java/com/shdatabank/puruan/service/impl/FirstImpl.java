package com.shdatabank.puruan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shdatabank.puruan.dao.FirstDao;
import com.shdatabank.puruan.service.FirstService;

@Service
public class FirstImpl implements FirstService{
	@Autowired
	FirstDao dao;

	@Override
	public void firstBiz() {
		dao.getBuildingByID(3);
	}

}
