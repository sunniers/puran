package com.shdatabank.puruan.dao;

import static org.junit.Assert.*;
import javax.annotation.Resource;
import org.junit.Test;
import com.shdatabank.puruan.model.ProjectAndPurchase;
import com.shdatabank.puruan.model.ProjectPurchaseTask;

public class CeativeResourceTransactionDaoTest {

	@Resource CeativeResourceTransactionDao ceativeResourceTransactionDao;
	
	@Test
	public void testSelectProjectPurchaseTask() {
		ProjectAndPurchase projectAndPurchase = new ProjectAndPurchase();
		projectAndPurchase.setCreativeResourceId((long) 1);
		projectAndPurchase.setProjectId((long) 12);
		projectAndPurchase.setProjectTaskId((long) 12);
		ProjectPurchaseTask ProjectPurchaseTask = ceativeResourceTransactionDao.selectProjectPurchaseTask(projectAndPurchase);
		System.out.println(ProjectPurchaseTask);
	}

	@Test
	public void testUpdateProjectPurchaseTaskCount() {
		fail("Not yet implemented");
	}

}
