package ro.ubbcluj.rabbit.web.controller;

import org.springframework.web.bind.annotation.*;
import ro.ubbcluj.rabbit.core.service.RabbitHoleService;
import ro.ubbcluj.rabbit.web.converter.RabbitHoleDtoConverter;
import ro.ubbcluj.rabbit.web.dto.RabbitHoleDto;
import ro.ubbcluj.rabbit.web.dto.RabbitHolesDto;

@RestController
public class RabbitHoleController {
    private final RabbitHoleService rabbitHoleService;

    public RabbitHoleController(RabbitHoleService rabbitHoleService) {
        this.rabbitHoleService = rabbitHoleService;
    }

    @PostMapping("/rabbit-holes")
    public void saveRabbitHole(@RequestBody RabbitHoleDto rabbitHoleDto) {
        var rabbitHole = RabbitHoleDtoConverter.convert(rabbitHoleDto);
        rabbitHoleService.saveRabbitHole(rabbitHole);
    }

    @GetMapping("/rabbit-holes")
    public RabbitHolesDto findAllRabbitHoles() {
        var rabbitHoles = rabbitHoleService.findAllRabbitHoles();
        return RabbitHoleDtoConverter.convert(rabbitHoles);
    }

    @GetMapping("/rabbit-holes/filtered")
    public RabbitHolesDto findAllRabbitHolesLike(@RequestParam String name) {
        System.out.println(name);
        var rabbitHoles = rabbitHoleService.findRabbitHolesLike(name);
        return RabbitHoleDtoConverter.convert(rabbitHoles);
    }

    @PutMapping("rabbit-holes")
    public void updateRabbitHole(@RequestBody RabbitHoleDto rabbitHoleDto) {
        var rabbitHole = RabbitHoleDtoConverter.convert(rabbitHoleDto);
        rabbitHoleService.updateRabbitHole(rabbitHole);
    }

    @DeleteMapping("rabbit-holes/{id}")
    public void deleteRabbitHole(@PathVariable Long id) {
        rabbitHoleService.deleteRabbitHole(id);
    }
}
