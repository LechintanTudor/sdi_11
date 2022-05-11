package ro.ubbcluj.rabbit.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubbcluj.rabbit.core.model.Rabbit;

public interface RabbitRepository extends JpaRepository<Rabbit, Long> {
}
