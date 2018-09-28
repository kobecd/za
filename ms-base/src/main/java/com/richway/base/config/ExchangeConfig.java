package com.richway.base.config;

import com.richway.rabbitmq.config.RabbitMqExchange;
import com.richway.rabbitmq.config.RabbitMqQueue;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Boao on 2018/6/22.
 */
@Configuration
public class ExchangeConfig {

    @Autowired
    private RabbitAdmin rabbitAdmin;



    /**
     *  将路由键和某模式进行匹配。此时队列需要绑定要一个模式上。符号“#”匹配一个或多个词，符号“*”匹配不多不少一个词。因此“audit.#”能够匹配到“audit.irs.corporate”，但是“audit.*” 只会匹配到“audit.irs”
     *  默认：, durable = true, autoDelete = false
     * @return
     */
    @Bean
    public TopicExchange productTopicExchange(){
        TopicExchange contractTopicExchange=new TopicExchange(RabbitMqExchange.PRODUCT_EXCHANGE_NAME);
        rabbitAdmin.declareExchange(contractTopicExchange);
        return contractTopicExchange;
    }


    @Bean
    public Queue productQueueGeneric(){
        Queue queue=new Queue(RabbitMqQueue.PRODUCT_QUEUE_GENERIC_NAME);
        rabbitAdmin.declareQueue(queue);
        return queue;
    }
    @Bean
    public Queue productQueueSpecific(){
        Queue queue=new Queue(RabbitMqQueue.PRODUCT_QUEUE_SPECIFIC_NAME,true);
        rabbitAdmin.declareQueue(queue);
        return queue;
    }

    @Bean
    public Binding declareBindingGeneric(){
        Binding binding= BindingBuilder.bind(productQueueGeneric()).to(productTopicExchange()).with(RabbitMqQueue.PRODUCT_ROUTING_KEY);
        rabbitAdmin.declareBinding(binding);
        return binding;
    }

    @Bean
    public Binding declareBindingSpecific() {
        Binding binding= BindingBuilder.bind(productQueueSpecific()).to(productTopicExchange()).with(RabbitMqQueue.PRODUCT_ROUTING_KEY);
        rabbitAdmin.declareBinding(binding);
        return binding;
    }
}
