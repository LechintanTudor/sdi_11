package ro.ubbcluj.rabbit.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ro.ubbcluj.rabbit.core.model.Subscription;
import ro.ubbcluj.rabbit.core.repository.SubscriptionRepository;

import java.util.List;

@Service
public class SubscriptionService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubscriptionService.class);

    private final SubscriptionRepository subscriptions;

    public SubscriptionService(SubscriptionRepository subscriptions) {
        this.subscriptions = subscriptions;
    }

    public void saveSubscription(Subscription subscription) {
        LOGGER.trace("SubscriptionService - saveSubscription({})", subscription);
        subscriptions.save(subscription);
    }

    public List<Subscription> findAllSubscriptions() {
        LOGGER.trace("SubscriptionService - findAllSubscriptions()");
        return subscriptions.findAll();
    }

    public void deleteSubscription(Subscription subscription) {
        LOGGER.trace("SubscriptionService - deleteSubscription({})", subscription);
        subscriptions.delete(subscription);
    }
}
