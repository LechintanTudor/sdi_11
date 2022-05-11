package ro.ubbcluj.rabbit.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubbcluj.rabbit.core.model.RabbitHole;

import java.util.List;

public interface RabbitHoleRepository extends JpaRepository<RabbitHole, Long> {
    List<RabbitHole> findByNameLike(String name);
}
