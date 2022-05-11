package ro.ubbcluj.rabbit.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@AllArgsConstructor
@Data
@Entity
@IdClass(SubscriptionId.class)
@NoArgsConstructor
public class Subscription implements Serializable {
    @Id
    private Long rabbitId;
    @Id
    private Long rabbitHoleId;
}
