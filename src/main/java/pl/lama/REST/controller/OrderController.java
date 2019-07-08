package pl.lama.REST.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lama.REST.domain.model.Order;
import pl.lama.REST.repositories.OrderRepository;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @GetMapping("/orders")
    List<Order> all() {
        return orderRepository.findAll();
    }

}
