package com.vdimri.sender;

public class RequestMessageBody {

    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String pin;
    private String country;

    public RequestMessageBody() {
    }

    public RequestMessageBody(String addressLine1, String addressLine2, String city, String state, String pin, String country) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.pin = pin;
        this.country = country;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPin() {
        return pin;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "RequestBody{" +
                "addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pin='" + pin + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}