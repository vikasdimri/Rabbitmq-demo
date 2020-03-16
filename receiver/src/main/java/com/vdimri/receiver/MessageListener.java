package com.vdimri.receiver;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageListener {
    private final Messaging messaging;
    private MeterRegistry meterRegistry;

    public MessageListener(Messaging messaging, MeterRegistry meterRegistry) {
        this.messaging = messaging;
        this.meterRegistry = meterRegistry;
    }

    @StreamListener(Messaging.ADDRESS)
    public void handleAddressMessage(@Payload Address message) {
        meterRegistry.counter("address.added").increment();
        log.info("Add address: " + message.toString());
    }
}
