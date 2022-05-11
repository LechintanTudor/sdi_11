package ro.ubbcluj.rabbit.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class RabbitHole {
    private @Id
    @GeneratedValue Long id;
    private String name;
}
