package ro.ubbcluj.rabbit.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class SubscriptionId implements Serializable {
    private Long rabbitId;
    private Long rabbitHoleId;
}
