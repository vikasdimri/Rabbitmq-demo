package com.vdimri.rabbitmq.demo.receiver;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface Messaging {

    String ADDRESS_MESSAGE = "address";

    @Input (ADDRESS_MESSAGE)
    MessageChannel getMyMessageChannel();

}
