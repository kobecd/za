package com.richway.rabbitmq.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Created by Boao on 2018/6/21.
 */
@JsonAutoDetect( fieldVisibility = JsonAutoDetect.Visibility.ANY )
public class EntityWrapperAmqp<E> {

    private E entity;
    private AmqpOperation amqpOperation;

    public EntityWrapperAmqp(E entity, AmqpOperation amqpOperation) {
        this.entity = entity;
        this.amqpOperation = amqpOperation;
    }


    public EntityWrapperAmqp() {
    }



    public void setEntity(E entity) {
        this.entity = entity;
    }

    public void setAmqpOperation(AmqpOperation amqpOperation) {
        this.amqpOperation = amqpOperation;
    }

    public E getEntity() {
        return entity;
    }

    public AmqpOperation getAmqpOperation() {
        return amqpOperation;
    }

}
