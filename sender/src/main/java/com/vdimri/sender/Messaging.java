package com.vdimri.sender;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Messaging {

    String ADDRESS = "address";

    @Output(ADDRESS)
    MessageChannel getMyMessageChannel();

}
