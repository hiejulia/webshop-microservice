package project.webshop.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.webshop.domain.Address;
import project.webshop.repository.AddressRepository;


import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Optional<Address> findOne(Long id) {
        return Optional.ofNullable(addressRepository.findOne(id));
    }

    public Address save(Address address) {
        return addressRepository.save(address);
    }

    public void delete(Long id) {
        addressRepository.delete(id);
    }
}