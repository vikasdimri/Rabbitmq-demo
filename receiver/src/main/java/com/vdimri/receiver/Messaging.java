package com.vdimri.receiver;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface Messaging {

    String ADDRESS = "address";

    @Input (ADDRESS)
    MessageChannel getMyMessageChannel();

}
