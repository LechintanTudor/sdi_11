package ro.ubbcluj.rabbit.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubbcluj.rabbit.core.model.RabbitHole;
import ro.ubbcluj.rabbit.core.repository.RabbitHoleRepository;

import java.util.List;

@Service
public class RabbitHoleService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitHoleService.class);

    private final RabbitHoleRepository rabbitHoles;

    public RabbitHoleService(RabbitHoleRepository rabbitHoles) {
        this.rabbitHoles = rabbitHoles;
    }

    public void saveRabbitHole(RabbitHole rabbitHole) {
        LOGGER.trace("RabbitHoleService - saveRabbitHole({})", rabbitHole);
        rabbitHoles.save(rabbitHole);
    }

    public List<RabbitHole> findAllRabbitHoles() {
        LOGGER.trace("RabbitHoleService - findAllRabbitHoles()");
        return rabbitHoles.findAll();
    }

    @Transactional
    public void updateRabbitHole(RabbitHole rabbitHole) {
        LOGGER.trace("RabbitHoleService - updateRabbitHole({})", rabbitHole);
        rabbitHoles.findById(rabbitHole.getId()).ifPresent(oldRabbitHole -> {
            LOGGER.trace("RabbitHoleService - updated rabbit hole name");
            oldRabbitHole.setName(rabbitHole.getName());
        });
    }

    public void deleteRabbitHole(Long id) {
        LOGGER.trace("RabbitHoleService - updateRabbitHole({})", id);
        rabbitHoles.deleteById(id);
    }
}
