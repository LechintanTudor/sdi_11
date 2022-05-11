package ro.ubbcluj.rabbit.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubbcluj.rabbit.core.service.RabbitService;
import ro.ubbcluj.rabbit.web.converter.RabbitDtoConverter;
import ro.ubbcluj.rabbit.web.dto.RabbitsDto;

@RestController
public class RabbitController {
    private final RabbitService rabbitService;

    public RabbitController(RabbitService rabbitService) {
        this.rabbitService = rabbitService;
    }

    @GetMapping("/rabbits")
    public RabbitsDto findAllRabbits() {
        var rabbits = rabbitService.findAllRabbits();
        return RabbitDtoConverter.convert(rabbits);
    }
}
