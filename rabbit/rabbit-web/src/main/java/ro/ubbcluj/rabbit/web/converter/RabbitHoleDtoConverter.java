package ro.ubbcluj.rabbit.web.converter;

import ro.ubbcluj.rabbit.core.model.RabbitHole;
import ro.ubbcluj.rabbit.web.dto.RabbitHoleDto;
import ro.ubbcluj.rabbit.web.dto.RabbitHolesDto;

import java.util.List;

public class RabbitHoleDtoConverter {
    public static RabbitHoleDto convert(RabbitHole rabbitHole) {
        return new RabbitHoleDto(rabbitHole.getId(), rabbitHole.getName());
    }

    public static RabbitHolesDto convert(List<RabbitHole> rabbitHoles) {
        return new RabbitHolesDto(rabbitHoles.stream().map(RabbitHoleDtoConverter::convert).toList());
    }

    public static RabbitHole convert(RabbitHoleDto rabbitHoleDto) {
        return new RabbitHole(rabbitHoleDto.id(), rabbitHoleDto.name());
    }
}
