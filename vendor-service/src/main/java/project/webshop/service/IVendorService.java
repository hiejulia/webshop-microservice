package project.webshop.service;


import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import project.webshop.entity.Vendor;


@Service
@Component
public interface IVendorService {

    public Vendor getVendorDetails(String id);

    public String saveVendorDetails(Vendor vendor);

    public List<Vendor> getAllVendors();


}