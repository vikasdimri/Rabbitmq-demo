package com.vdimri.sender;


import io.micrometer.core.instrument.MeterRegistry;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/api")
public class AddressBookController {

    private Messaging messaging;
    private MeterRegistry meterRegistry;

    public AddressBookController(Messaging messaging, MeterRegistry meterRegistry) {
        this.messaging = messaging;
        this.meterRegistry = meterRegistry;
    }

    @ApiOperation(value = "Endpoint to add address in the address book")
    @PostMapping(path= "/add", consumes = "application/json", produces = "application/json")
    public void addInAddressBook(@RequestBody Address request) {
        meterRegistry.counter("address.add.request").increment();
        log.debug("Add address: "+request.toString());
        Message<Address> message = MessageBuilder.withPayload(request).build();
        this.messaging.getMyMessageChannel().send(message);
    }
}