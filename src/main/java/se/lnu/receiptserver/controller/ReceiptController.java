package se.lnu.receiptserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import se.lnu.receiptserver.model.Order;
import se.lnu.receiptserver.repository.OrderRepository;

@Controller
public class ReceiptController {

    private final OrderRepository repository;

    public ReceiptController(
            OrderRepository repository
    ) {

        this.repository = repository;
    }

    @GetMapping("/receipt/{orderNumber}")
    public String receipt(
            @PathVariable String orderNumber,
            Model model
    ) {

        Order order =
                repository.getByOrderNumber(
                        orderNumber
                );

        model.addAttribute(
                "order",
                order
        );

        return "receipt";
    }
}