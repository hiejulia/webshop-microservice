package project.webshop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import project.webshop.domain.Address;
import project.webshop.exception.NotFoundException;
import project.webshop.service.AddressService;


import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> findAll() {
        return addressService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Address findOne(@PathVariable Long id) {
        return addressService.findOne(id).orElseThrow(NotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Address create(@RequestBody Address address) {
        address.setId(null);
        return addressService.save(address);
    }

    @PutMapping(path = "/{id}")
    public void update(@PathVariable Long id, Address address) {
        addressService.save(address);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        addressService.delete(id);
    }
}