package com.richway.base.aop;

import com.richway.base.domain.EnterpriseAddress;
import com.richway.rabbitmq.config.EntityWrapperAmqp;
import com.richway.rabbitmq.config.RabbitMqExchange;
import com.richway.rabbitmq.config.RabbitMqQueue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by Boao on 2018/6/21.
 */
@Service
public class EnterpriseAddressQueueSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void convertAndSend(final EntityWrapperAmqp<?> entity) {
        try {
            String uuid = UUID.randomUUID().toString();
            CorrelationData correlationId = new CorrelationData(uuid);
//            this.rabbitTemplate.convertAndSend(RabbitMqQueue.PRODUCT_ROUTING_KEY, entity.getEntity());
            this.rabbitTemplate.convertSendAndReceive(RabbitMqExchange.PRODUCT_EXCHANGE_NAME, RabbitMqQueue.PRODUCT_ROUTING_KEY, entity.getEntity(), correlationId);
        }catch (Exception e){
            String s=e.getMessage();
        }
    }

    public void sendMessage(final EntityWrapperAmqp<?> entity) {
        rabbitTemplate.convertAndSend(RabbitMqExchange.PRODUCT_EXCHANGE_NAME, RabbitMqQueue.PRODUCT_ROUTING_KEY, entity);
    }
}
