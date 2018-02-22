package project.webshop.controller;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import project.webshop.model.Customer;
import project.webshop.service.CustomerService;


@CrossOrigin
@BaseRestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes ="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody Customer customer) {

        return customerService.createCustomer(customer);
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<HttpStatus> authenticateUser(@RequestBody Customer customer) {
        if(customerService.authenticateCustomer(customer))
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        else
            return new ResponseEntity<HttpStatus>(HttpStatus.UNAUTHORIZED);



    }


}
