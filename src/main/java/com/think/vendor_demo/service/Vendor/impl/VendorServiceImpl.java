package com.think.vendor_demo.service.Vendor.impl;

import com.think.vendor_demo.exception.VendorException.NotFoundVendorException;
import com.think.vendor_demo.model.Vendor;
import com.think.vendor_demo.repository.VendorRepository;
import com.think.vendor_demo.service.Vendor.VendorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {                                                                                                                                                                 

    @Autowired
    private VendorRepository vendorRepository;

    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    public String createVendor(Vendor vendor) {
        vendorRepository.save(vendor);
        return "Success";
    }

    @Override
    public String updateVendor(Vendor vendor) {
        vendorRepository.save(vendor);
        return "Success";
    }

    @Override
    public boolean deleteVendor(long vendorId) {
        // More Business Logic
        if(vendorRepository.findById(vendorId).isEmpty())
            throw new NotFoundVendorException("Requested Vendor does not exist");
        vendorRepository.deleteById(vendorId);
        return true;
    }

    @Override
    public Vendor getVendor(long vendorId) {
        // More Business Logic
        return vendorRepository.findById(vendorId)
                .orElseThrow(() -> new NotFoundVendorException("Requested Vendor does not exist"));
    }

    @Override
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }
    @Override
    public List<Vendor> getByVendorName(String vendorName)
    {
        return vendorRepository.findByVendorName(vendorName);
    }

}
