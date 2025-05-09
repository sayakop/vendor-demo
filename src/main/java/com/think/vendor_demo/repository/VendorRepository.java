package com.think.vendor_demo.repository;

import com.think.vendor_demo.model.Vendor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {
    List<Vendor> findByVendorName(String vendorName);

}
