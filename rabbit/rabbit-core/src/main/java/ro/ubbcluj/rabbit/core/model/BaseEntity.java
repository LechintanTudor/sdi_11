package ro.ubbcluj.rabbit.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@AllArgsConstructor
@Data
@MappedSuperclass
@NoArgsConstructor
@ToString
public abstract class BaseEntity<ID extends Serializable> implements Serializable {
    @GeneratedValue
    @Id
    protected ID id;
}
