package com.example.community;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import javax.sql.DataSource;

@SpringBootTest
class CommunityApplicationTests {

	@Autowired
	DataSource dataSource;

	@Test
	void contextLoads() throws Exception{
		System.out.println("获取的数据库连接为:"+dataSource.getConnection());
	}

}
