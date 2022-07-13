package com.example.community;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.net.MalformedURLException;
import java.net.URL;

@SpringBootTest
class CommunityApplicationTests {
	@Test
	void test() throws MalformedURLException {
		URL url = new URL("www");
		System.out.printf(url.toString());
	}

}
