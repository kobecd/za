package com.richway.stream.sender;

import com.richway.stream.receiver.InSinkReceiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

import java.util.Date;

/**
 * Created by Boao on 2018/6/11.
 */
@EnableBinding(value = {InSinkSender.SinkOutput.class})
public class InSinkSender {

    private static Logger logger = LoggerFactory.getLogger(InSinkReceiver.class);

    @Bean
    @InboundChannelAdapter(value = SinkOutput.OUTPUT,poller = @Poller(fixedDelay = "2000"))
    public MessageSource<Date> timerMessageSource() {
        return () -> new GenericMessage<Date>(new Date());
    }


    public interface SinkOutput {

        String OUTPUT = "input1";

        @Output(SinkOutput.OUTPUT)
        MessageChannel output();
    }
}
