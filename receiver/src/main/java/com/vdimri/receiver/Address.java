package com.vdimri.receiver;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Address {
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String pin;
    private String country;
}
