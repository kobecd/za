package com.richway.stream.receiver;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Boao on 2018/6/11.
 */
@EnableBinding(value = {Sink.class})
public class InSinkReceiver {

    private static Logger logger = LoggerFactory.getLogger(InSinkReceiver.class);

    @ServiceActivator(inputChannel = "input1")
    public void receive(Object payload) {
        logger.info("Received: "+ payload);
    }

    @Transformer(inputChannel = "input1",outputChannel = "input1")
    public Object transform(Date message) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(message);
    }
}
