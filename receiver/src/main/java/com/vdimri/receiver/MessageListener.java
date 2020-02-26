package com.vdimri.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageListener {
    private final Messaging messaging;

    public MessageListener(Messaging messaging) {
        this.messaging = messaging;
    }

    @StreamListener(Messaging.ADDRESS)
    public void handleAddressMessage(@Payload Address message) {
        log.info("Add address: " + message.toString());
    }
}
