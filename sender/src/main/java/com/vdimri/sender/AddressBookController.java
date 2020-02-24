package com.vdimri.sender;


import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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

    public AddressBookController(Messaging messaging) {
        this.messaging = messaging;
    }

    @ApiOperation(value = "Endpoint to add address in the address book")
    //@PostMapping(consumes = "application/json", path = {"add"})
    @PostMapping(path= "/add", consumes = "application/json", produces = "application/json")
    public void addInAddressBook(@RequestBody Address request) {
        log.info("RequestMessageBody ::::"+request.toString());

        log.info("Address sender :"+request.toString());
        log.info("AddressLine1: "+request.getAddressLine1());
        log.info("AddressLine2: "+request.getAddressLine2());
        log.info("City: "+request.getCity());
        log.info("State: "+request.getState());
        log.info("Country: "+request.getCountry());
        log.info("Pin: "+request.getPin());
        Message<Address> message = MessageBuilder.withPayload(request).build();
        this.messaging.getMyMessageChannel().send(message);
    }

    @ApiOperation(value = "Endpoint to add address in the address book")
    @PostMapping(value = "/persons", produces = "application/json")
    public void testMethod(@org.springframework.web.bind.annotation.RequestBody Address address) {
        if (null == address) {
            log.info("Address sender :", address.toString());
            log.info("AddressLine1: ", address.getAddressLine1());
            log.info("AddressLine2: ", address.getAddressLine2());
            log.info("City: ", address.getCity());
            log.info("State: ", address.getState());
            log.info("Country: ", address.getCountry());
            log.info("Pin: ", address.getPin());
        } else{
            log.info("Empty request");
        }
    }

    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody RequestMessageBody request)
    {
       log.info("RequestMessageBody ::::"+request.toString());

        log.info("Address sender :"+request.toString());
        log.info("AddressLine1: "+request.getAddressLine1());
        log.info("AddressLine2: "+request.getAddressLine2());
        log.info("City: "+request.getCity());
        log.info("State: "+request.getState());
        log.info("Country: "+request.getCountry());
        log.info("Pin: "+request.getPin());
        return null;
    }
}
