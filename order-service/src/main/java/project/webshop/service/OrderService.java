package project.webshop.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.webshop.model.Order;
import project.webshop.repository.OrderRepository;


@Service("orderService")
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    private Log log = LogFactory.getLog(OrderService.class);

    public List<Order> createOrder(List<Order> orderList) {
        return orderRepository.save(orderList);
    }

}
