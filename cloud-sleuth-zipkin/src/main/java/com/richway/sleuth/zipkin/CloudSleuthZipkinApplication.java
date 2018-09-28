package com.richway.sleuth.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

//@EnableZipkinServer //开启ZipkinServer，通过http的方式来对跟踪信息进行收集
@EnableZipkinStreamServer //开启ZipkinStreamServer,通过消息中间件(rabbit)的方式来对跟踪信息进行收集
@SpringBootApplication
public class CloudSleuthZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudSleuthZipkinApplication.class, args);
	}
}
