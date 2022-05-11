package ro.ubbcluj.rabbit.web.controller;

import org.springframework.web.bind.annotation.*;
import ro.ubbcluj.rabbit.core.service.RabbitService;
import ro.ubbcluj.rabbit.web.converter.RabbitDtoConverter;
import ro.ubbcluj.rabbit.web.dto.RabbitDto;
import ro.ubbcluj.rabbit.web.dto.RabbitsDto;

@RestController
public class RabbitController {
    private final RabbitService rabbitService;

    public RabbitController(RabbitService rabbitService) {
        this.rabbitService = rabbitService;
    }

    @PostMapping("/rabbits")
    public void saveRabbit(@RequestBody RabbitDto rabbitDto) {
        var rabbit = RabbitDtoConverter.convert(rabbitDto);
        rabbitService.saveRabbit(rabbit);
    }

    @GetMapping("/rabbits")
    public RabbitsDto findAllRabbits() {
        var rabbits = rabbitService.findAllRabbits();
        return RabbitDtoConverter.convert(rabbits);
    }

    @PutMapping("/rabbits")
    public void updateRabbit(@RequestBody RabbitDto rabbitDto) {
        var rabbit = RabbitDtoConverter.convert(rabbitDto);
        rabbitService.updateRabbit(rabbit);
    }

    @DeleteMapping("/rabbits/{id}")
    public void deleteRabbitHole(@PathVariable Long id) {
        rabbitService.deleteRabbit(id);
    }
}
