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
    public void handleAddressMessage(@Payload Address message){
        log.info("Add address: ",message.toString());
        log.info("AddressLine1: ",message.getAddressLine1());
        log.info("AddressLine2: ",message.getAddressLine2());
        log.info("City: ",message.getCity());
        log.info("State: ",message.getState());
        log.info("Country: ",message.getCountry());
        log.info("Pin: ",message.getPin());
    }

}
