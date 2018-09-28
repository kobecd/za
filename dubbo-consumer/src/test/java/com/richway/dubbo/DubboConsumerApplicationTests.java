package com.richway.dubbo;

import com.richway.dubbo.service.ComputeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DubboConsumerApplication.class)
public class DubboConsumerApplicationTests {

	@Autowired
	ComputeService computeService;

	@Test
	public void testAdd() {
		System.out.println(computeService.add(2,3));
		Assert.assertEquals("dubbo-service:add",new Integer(3),computeService.add(1,2));
	}

}
