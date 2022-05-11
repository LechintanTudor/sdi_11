package ro.ubbcluj.rabbit.web.converter;

import ro.ubbcluj.rabbit.core.model.Rabbit;
import ro.ubbcluj.rabbit.web.dto.RabbitDto;
import ro.ubbcluj.rabbit.web.dto.RabbitsDto;

import java.util.List;

public class RabbitDtoConverter {
    public static RabbitDto convert(Rabbit rabbit) {
        return new RabbitDto(rabbit.getId(), rabbit.getUsername());
    }

    public static RabbitsDto convert(List<Rabbit> rabbits) {
        return new RabbitsDto(rabbits.stream().map(RabbitDtoConverter::convert).toList());
    }

    public static Rabbit convert(RabbitDto rabbitDto) {
        return new Rabbit(rabbitDto.id(), rabbitDto.username());
    }
}
