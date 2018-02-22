package project.webshop.service;
import org.springframework.stereotype.Service;
import project.webshop.model.Customer;


@Service
public interface ICustomerService {

    // creat customer
    public Customer createCustomer(Customer customer);



    // authenticate customer
    public boolean authenticateCustomer(Customer customer);

}
