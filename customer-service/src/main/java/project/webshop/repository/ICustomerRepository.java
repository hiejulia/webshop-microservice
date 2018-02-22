package project.webshop.repository;


import project.webshop.model.Customer;

import java.util.List;

public interface ICustomerRepository {

    // create customer
    public Customer createCustomer(Customer customer);

    // authenticate customer
    public boolean authenticateCustomer(Customer customer);

    // get all customer
    List<Customer> findAll();


}
