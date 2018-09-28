package com.richway.stream.sender;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * Created by Boao on 2018/6/11.
 */
@Component
public interface SinkSender {

    @Output(Sink.INPUT)
    MessageChannel output();
}
