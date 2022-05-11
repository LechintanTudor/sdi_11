package ro.ubbcluj.rabbit.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubbcluj.rabbit.core.model.Rabbit;
import ro.ubbcluj.rabbit.core.repository.RabbitRepository;

import java.util.List;

@Service
public class RabbitService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitService.class);

    private final RabbitRepository rabbits;

    public RabbitService(RabbitRepository rabbits) {
        this.rabbits = rabbits;
    }

    public void saveRabbit(Rabbit rabbit) {
        LOGGER.trace("RabbitService - saveRabbit({})", rabbit);
        rabbits.save(rabbit);
    }

    public List<Rabbit> findAllRabbits() {
        LOGGER.trace("RabbitService - findAllRabbits()");
        return rabbits.findAll();
    }

    @Transactional
    public void updateRabbit(Rabbit rabbit) {
        LOGGER.trace("RabbitService - updateRabbit({})", rabbit);
        rabbits.findById(rabbit.getId()).ifPresent(oldRabbit -> {
            LOGGER.trace("RabbitService - updated rabbit username");
            oldRabbit.setUsername(rabbit.getUsername());
        });
    }

    public void deleteRabbit(Long id) {
        LOGGER.trace("RabbitService - deleteById({})", id);
        rabbits.deleteById(id);
    }
}
