package com.vdimri.sender;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String pin;
    private String country;
}
