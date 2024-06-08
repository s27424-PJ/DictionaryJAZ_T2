package org.example.schroniskozwierzat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
public class AnimalType {
    @Id
    @GeneratedValue
    private Long id;

    private String type;
}
