package com.example.subscription;
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findBySubscriberName(String subscriberName);
}
