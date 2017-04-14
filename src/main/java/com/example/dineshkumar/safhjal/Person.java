package com.example.dineshkumar.safhjal;

/**
 * Created by Dinesh Kumar on 13-04-2017.
 */

public class Person {
    long aadhar;
    long phone;
    String address;
    String status;
    String comp;
    public long getAadhar() {
        return aadhar;
    }

    public long getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getStatus() {
        return status;
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }

    public void setAadhar(long aadhar) {
        this.aadhar = aadhar;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

