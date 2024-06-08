package org.example.schroniskozwierzat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Data
@Entity

public class Animal {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;

    @ValidateAnimalType
    private String species;
    private int age;


}

