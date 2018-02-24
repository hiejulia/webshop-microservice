package project.webshop.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import project.webshop.entity.Vendor;


@Component
public interface IVendorDao  {

    public List<Vendor> getVendorById(String id);


    public String  saveVendorDetails(Vendor vendor);


    public List<Vendor> getAllVendors();



}