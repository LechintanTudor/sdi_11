package ro.ubbcluj.rabbit.core.model;

import lombok.*;

import javax.persistence.Entity;

@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString(callSuper = true)
public class Rabbit extends BaseEntity<Long> {
    private String username;
    private String password;

    public Rabbit(Long id, String username, String password) {
        super(id);
        this.username = username;
        this.password = password;
    }
}
