package com.vdimri.rabbitmq.demo.sender;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Messaging {

    String ADDRESS = "my-message";

    @Output(ADDRESS)
    MessageChannel getMyMessageChannel();

}
