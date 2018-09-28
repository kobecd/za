package com.richway.base.aop;

import com.richway.base.domain.EnterpriseAddress;
import com.richway.rabbitmq.config.AmqpOperation;
import com.richway.rabbitmq.config.EntityWrapperAmqp;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Boao on 2018/6/21.
 */
@Component
@Aspect
public class EnterpriseAddressAspect {

    @Autowired
    private  EnterpriseAddressQueueSender queueSender;

    @AfterReturning(pointcut = "execution(* com.richway.base.dao.EnterpriseAddressMapper.insert(..))",returning = "ret")
    public void insertElasticsearch(JoinPoint joinPoint, Object ret) {
        EnterpriseAddress enterpriseAddress = (EnterpriseAddress)joinPoint.getArgs()[0];
        convertAndSend(new EntityWrapperAmqp(enterpriseAddress, AmqpOperation.CREATE));
    }

    private void convertAndSend(final EntityWrapperAmqp<?> entity) {
        this.queueSender.convertAndSend(entity);
    }
}
