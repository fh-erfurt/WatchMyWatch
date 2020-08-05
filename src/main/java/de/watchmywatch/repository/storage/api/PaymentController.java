package de.watchmywatch.repository.storage.api;

import de.watchmywatch.model.OrderManagment.Payment;
import de.watchmywatch.repository.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api")
public class PaymentController {
    @Autowired
    public PaymentRepository paymentRepository;

    // GET /api/payments returns all payments
    @GetMapping(path = "/payments")
    public @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    Iterable<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // GET /api/payment/:id returns payment with id
    @GetMapping(value = "/payments/{paymentId}")
    public @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    Payment getOnePayment(@PathVariable Integer paymentId) {
        return paymentRepository.findById(paymentId)
                .orElseThrow(() -> new NotFoundException("payment", paymentId));
    }

    // POST /api/payment creates a payment in the database and returns "Saved"
    @PostMapping(path = "/payments")
    public @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    Payment addNewPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    // PUT /api/payments/:id updates the payment with the id
    @PutMapping("/payments/{id}")
    public @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    Payment updatePayment(@PathVariable Integer id, @RequestBody Payment newPayment) {
        return paymentRepository.findById(id)
                .map(payment -> {
                    payment.setDatePaid(newPayment.getDatePaid());
                    payment.setPaymentMethod(newPayment.getPaymentMethod());
                    payment.setDetails(newPayment.getDetails());
                    return paymentRepository.save(payment);
                })
                .orElseGet(() -> {
                    newPayment.setId(id);
                    return paymentRepository.save(newPayment);
                });
    }

    // DELETE /api/payments/:id deletes the payment with id and returns "Deleted"
    @DeleteMapping(path = "/payments/{id}")
    public @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePayment(@PathVariable Integer id) {
        paymentRepository.deleteById(id);
    }
}