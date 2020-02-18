package com.vdimri.rabbitmq.demo.sender;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String pin;
    private String country;
}
