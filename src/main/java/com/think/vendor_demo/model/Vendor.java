package com.think.vendor_demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Vendor {

    @Id
    private String vendorId;
    private String vendorName;
    private String vendorAddress;
    private String vendorPhoneNumber;
    private String vendorAge;


    public Vendor() {
    }


    public Vendor
    (String vendorId, String vendorName, String vendorAddress, String vendorPhoneNumber,String vendorAge) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.vendorAddress = vendorAddress;
        this.vendorPhoneNumber = vendorPhoneNumber;
        this.vendorAge = vendorAge;
    }


    public String getVendorId() {
        return vendorId;
    }
    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }
    public String getVendorName() {
        return vendorName;
    }
    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }
    public String getVendorAddress() {
        return vendorAddress;
    }
    public void setVendorAddress(String vendorAddress) {
        this.vendorAddress = vendorAddress;
    }
    public String getVendorPhoneNumber() {
        return vendorPhoneNumber;
    }
    public void setVendorPhoneNumber(String vendorPhoneNumber) {
        this.vendorPhoneNumber = vendorPhoneNumber;
    }
    public String getVendorAge() {
        return vendorAge;
    }
    public void setVendorAge(String vendorAge) {
        this.vendorAge = vendorAge;
    }

}
