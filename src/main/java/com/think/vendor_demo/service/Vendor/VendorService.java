package com.think.vendor_demo.service.Vendor;

import com.think.vendor_demo.model.Vendor;

import java.util.List;

public interface VendorService {
    public String createVendor(Vendor vendor);
    public String updateVendor(Vendor vendor);
    public boolean deleteVendor(long vendorId);
    public Vendor getVendor(long vendorId);
    public List<Vendor> getAllVendors();
    public List<Vendor> getByVendorName(String vendorName);
}
