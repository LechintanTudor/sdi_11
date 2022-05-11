package ro.ubbcluj.rabbit.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubbcluj.rabbit.core.model.RabbitHole;

public interface RabbitHoleRepository extends JpaRepository<RabbitHole, Long> {
}
