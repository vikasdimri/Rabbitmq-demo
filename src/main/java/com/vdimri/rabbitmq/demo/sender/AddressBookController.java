package com.vdimri.rabbitmq.demo.sender;


import io.swagger.annotations.ApiOperation;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class AddressBookController {

    private Messaging messaging;

    public AddressBookController(Messaging messaging) {
        this.messaging = messaging;
    }

    @ApiOperation(value = "Endpoint to add address in the address book")
    @PostMapping(consumes = "application/json", path = {"add"})
    public void addInAddressBook(@RequestBody Address address) {
        Message<Address> message = MessageBuilder.withPayload(address).build();
        this.messaging.getMyMessageChannel().send(message);
    }
}
