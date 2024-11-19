package com.example.subscription;
@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subscriberName;
    private LocalDate dateSubscribed;
    private LocalDate dateReturned;
    private String bookId;

    // Getters and Setters
}
