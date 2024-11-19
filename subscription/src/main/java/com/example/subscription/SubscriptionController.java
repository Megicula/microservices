package com.example.subscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.books.repository.BookRepository;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {
    @Autowired
    private SubscriptionRepository subscriptionRepository;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Subscription> getAllSubscriptions(@RequestParam(required = false) String subscriberName) {
        if (subscriberName != null) {
            return subscriptionRepository.findBySubscriberName(subscriberName);
        }
        return subscriptionRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createSubscription(@RequestBody Subscription subscription) {
        Book book = bookRepository.findById(subscription.getBookId()).orElse(null);
        if (book != null && book.getAvailableCopies() > 0) {
            book.setAvailableCopies(book.getAvailableCopies() - 1);
            bookRepository.save(book);
            subscriptionRepository.save(subscription);
            return ResponseEntity.status(HttpStatus.CREATED).body("Subscription created successfully");
        } else {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Book copies not available");
        }
    }
}