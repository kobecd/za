package com.richway.base;

import com.richway.base.dao.UserMapper;
import com.richway.base.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MsBaseApplication.class)
@Transactional
public class MsBaseApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	@Rollback
	public void contextLoads() {
		userMapper.insert("帅哥",20);
		User user = userMapper.findByName("帅哥");
		System.out.println(user);
		Assert.assertEquals(20,user.getAge().intValue());
	}

}
