package com.vdimri.rabbitmq.demo.publisher.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Messaging {

    String MY_MESSAGE = "my-message";

    @Output(MY_MESSAGE)
    MessageChannel getMyMessageChannel();

}
