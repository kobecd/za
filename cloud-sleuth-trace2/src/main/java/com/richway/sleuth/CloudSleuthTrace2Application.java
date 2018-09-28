package com.richway.sleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class CloudSleuthTrace2Application {

	private final Logger logger = Logger.getLogger(getClass());

	@RequestMapping(value = "/trace-2",method = RequestMethod.GET)
	public String trace(HttpServletRequest request) {
		logger.info("===<call trace-2, TraceId={}, SpanId={}>===");
		return "Trace";
	}

	public static void main(String[] args) {
		SpringApplication.run(CloudSleuthTrace2Application.class, args);
	}
}
