package ro.ubbcluj.rabbit.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubbcluj.rabbit.core.model.Subscription;
import ro.ubbcluj.rabbit.core.model.SubscriptionId;

public interface SubscriptionRepository extends JpaRepository<Subscription, SubscriptionId> {
}
