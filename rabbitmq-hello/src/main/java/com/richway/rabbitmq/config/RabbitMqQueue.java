package com.richway.rabbitmq.config;

/**
 * 消息队列配置
 */
public interface RabbitMqQueue {
    String PRODUCT_QUEUE_GENERIC_NAME = "productGenericQueue";
    String PRODUCT_QUEUE_SPECIFIC_NAME = "productappSpecificQueue";
    String PRODUCT_ROUTING_KEY = "product.messages.key";
    String TRADE_ROUTING_KEY = "trade.messages.key";
    String TRADE_QUEUE_GENERIC_NAME = "tradeGenericQueue";
    String TRADE_QUEUE_SPECIFIC_NAME = "tradeappSpecificQueue";
}
