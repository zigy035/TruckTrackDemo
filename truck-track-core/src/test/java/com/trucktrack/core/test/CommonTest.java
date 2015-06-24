package com.trucktrack.core.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:com/trucktrack/core/test/applicationContext-test.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public abstract class CommonTest extends AbstractTransactionalJUnit4SpringContextTests
{
	protected static final String OBJECT_ID = "uniqueObjectId";
	protected static final String NEW = "New";
	protected static final String UPDATED = "Updated";

	
	protected Date parseDate(String strDate)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try
		{
			return dateFormat.parse(strDate);
		}
		catch (Exception e)
		{
			return new Date();
		}
	}
	
}
