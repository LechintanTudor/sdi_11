package ro.ubbcluj.rabbit.web.controller;

import org.springframework.web.bind.annotation.*;
import ro.ubbcluj.rabbit.core.model.Subscription;
import ro.ubbcluj.rabbit.core.service.SubscriptionService;
import ro.ubbcluj.rabbit.web.converter.SubscriptionDtoConverter;
import ro.ubbcluj.rabbit.web.dto.SubscriptionDto;
import ro.ubbcluj.rabbit.web.dto.SubscriptionsDto;

@RestController
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping("/subscriptions")
    public void saveSubscription(@RequestBody SubscriptionDto subscriptionDto) {
        var subscription = SubscriptionDtoConverter.convert(subscriptionDto);
        subscriptionService.saveSubscription(subscription);
    }

    @GetMapping("/subscriptions")
    public SubscriptionsDto findAllSubscriptions() {
        var subscriptions = subscriptionService.findAllSubscriptions();
        return SubscriptionDtoConverter.convert(subscriptions);
    }

    @DeleteMapping("/subscriptions/{rabbitId}/{rabbitHoleId}")
    public void deleteSubscription(@PathVariable Long rabbitId, @PathVariable Long rabbitHoleId) {
        var subscription = new Subscription(rabbitId, rabbitHoleId);
        subscriptionService.deleteSubscription(subscription);
    }
}
