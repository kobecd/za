package com.richway.base.domain;

import lombok.Setter;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Boao on 2018/6/22.
 */
@Configuration
@Getter
@Setter
@ConfigurationProperties(prefix = "spring.rabbitmq")
public class RabbitMq {

    private String host;

    private Integer port;

    private String username;

    private String password;

    private String virtualHost;

    private Boolean publisherConfirms;
}
