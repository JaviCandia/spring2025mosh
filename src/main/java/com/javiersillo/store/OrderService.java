package com.javiersillo.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// This service consumes the PaymentService interface to decouple payment provider implementations.
@Service
public class OrderService {
    private PaymentService paymentService;

    public OrderService() {
    }

    // This tells Spring to prefer this constructor | not necessary when you have only 1 constructor
    @Autowired
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder() {
        paymentService.processPayment(10);
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
