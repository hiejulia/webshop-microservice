package project.webshop.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import project.webshop.exception.ServiceException;
import project.webshop.model.Customer;
import project.webshop.rabbitmq.TaskMessage;
import project.webshop.rabbitmq.TaskProducer;
import project.webshop.repository.ICustomerRepository;


@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Autowired
    private TaskProducer taskProducer;

    @Override
    public Customer createCustomer(Customer customer) {
        customer.setCustomerId(UUID.randomUUID());
        customer.setCreateDate(new Date());
        if (!isValidCreateUserRequest(customer)) {
            throw new ServiceException("Invalid create user request.");
        }
        sendEmail(customer.getEmail());
        return iCustomerRepository.createCustomer(customer);
    }

    private void sendEmail(String email) {
        TaskMessage taskMessage = new TaskMessage();
        taskMessage.setEmailId(email);
        taskProducer.sendNewTask(taskMessage);

    }

    private boolean isValidCreateUserRequest(Customer customer) {
        boolean isValid = false;
        if (customer != null && !StringUtils.isEmpty(customer.getCustomerId())
                && !StringUtils.isEmpty(customer.getPassword())) {
            isValid=true;
        }
        System.out.println(">>>>> isValidCreateUserRequest: " + isValid);

        return isValid;
    }


    @Override
    public boolean authenticateCustomer(Customer customer) {
        System.out.println("**In authenticate service class!");
        boolean isAuthenticated = false;
        if (customer != null) {
            if (!StringUtils.isEmpty(customer.getEmail())
                    && !StringUtils.isEmpty(customer.getPassword())) {
                isAuthenticated = iCustomerRepository.authenticateCustomer(customer);
            }
        }

        return isAuthenticated;
    }

}
