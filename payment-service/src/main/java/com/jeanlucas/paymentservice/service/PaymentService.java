package com.jeanlucas.paymentservice.service;

import com.jeanlucas.paymentservice.model.Payment;

public interface PaymentService {

    void sendPayment(Payment payment);

}
