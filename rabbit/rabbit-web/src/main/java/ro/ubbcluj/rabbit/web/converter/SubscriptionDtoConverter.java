package ro.ubbcluj.rabbit.web.converter;

import ro.ubbcluj.rabbit.core.model.Subscription;
import ro.ubbcluj.rabbit.web.dto.SubscriptionDto;
import ro.ubbcluj.rabbit.web.dto.SubscriptionsDto;

import java.util.List;

public class SubscriptionDtoConverter {
    public static SubscriptionDto convert(Subscription subscription) {
        return new SubscriptionDto(subscription.getRabbitId(), subscription.getRabbitHoleId());
    }

    public static SubscriptionsDto convert(List<Subscription> subscriptions) {
        return new SubscriptionsDto(subscriptions.stream().map(SubscriptionDtoConverter::convert).toList());
    }

    public static Subscription convert(SubscriptionDto subscriptionDto) {
        return new Subscription(subscriptionDto.rabbitId(), subscriptionDto.rabbitHoleId());
    }
}
