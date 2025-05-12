package com.think.vendor_demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.think.vendor_demo.model.Vendor;
import com.think.vendor_demo.response.VendorResponseHandler;
import com.think.vendor_demo.service.Vendor.VendorService;


import java.util.List;

@RestController
@RequestMapping("/vendor")
public class VendorController 
{
    VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping("/welcome")
    public ResponseEntity<String> welcomeMessage()
    {
        return new ResponseEntity<>("Welcome to the Vendor Details", HttpStatus.OK);
    }

    //Get a specific Vendor from Database
    @GetMapping("{vendorId}")
    public ResponseEntity<Object> getVendorDetails(@PathVariable("vendorId") long vendorId,
    @RequestParam(name = "raw", required = false, defaultValue = "false") boolean raw)
    {
    Vendor vendor = vendorService.getVendor(vendorId); // Use your actual service method here
    if (raw) {
        return new ResponseEntity<>(vendor, HttpStatus.OK);
    } else {
        return VendorResponseHandler.responseBuilder(
            "Requested Vendor Details Given Here",
            HttpStatus.OK,
            vendor
        );
    }
}

    //Get All Vendor Details from Database
    @GetMapping
    public ResponseEntity<List<Vendor>> getAllVendorDetails()
    {
        return new ResponseEntity<>(vendorService.getAllVendors(),HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> createVendorDetails(@RequestBody Vendor vendor)
    {
        vendorService.createVendor(vendor);
        return VendorResponseHandler.responseBuilder(
        "Requested Vendor details are here",
        HttpStatus.OK,
        vendor
    );
    }

    @PutMapping("")

    public String updateVendorDetails(@RequestBody Vendor vendor)
    {
        vendorService.updateVendor(vendor);
        return "Vendor Updated Successfully";

    }

    @DeleteMapping("/{vendorId}")
    public ResponseEntity<String> deleteVendorDetails(@PathVariable("vendorId") long vendorId)
    {
        boolean isVendorDeleted = vendorService.deleteVendor(vendorId);
        if(isVendorDeleted)
        {
            return new ResponseEntity<>("Vendor Deleted SuccessFully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Vendor Not Found", HttpStatus.NOT_FOUND);
        }

    }
}
