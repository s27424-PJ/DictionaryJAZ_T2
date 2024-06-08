package org.example.schroniskozwierzat;

import io.swagger.client.model.AnimalRequest;
import io.swagger.client.model.AnimalResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-08T19:01:49+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class AnimalMapperImpl implements AnimalMapper {

    @Override
    public Animal mapToAnimal(AnimalRequest request) {
        if ( request == null ) {
            return null;
        }

        Animal animal = new Animal();

        animal.setName( request.getName() );
        animal.setSpecies( request.getSpecies() );
        if ( request.getAge() != null ) {
            animal.setAge( request.getAge() );
        }

        return animal;
    }

    @Override
    public AnimalResponse mapEntityToResponse(Animal entity) {
        if ( entity == null ) {
            return null;
        }

        AnimalResponse animalResponse = new AnimalResponse();

        animalResponse.setId( entity.getId() );
        animalResponse.setName( entity.getName() );
        animalResponse.setSpecies( entity.getSpecies() );
        animalResponse.setAge( entity.getAge() );

        return animalResponse;
    }

    @Override
    public Animal update(AnimalRequest request, Animal animal) {
        if ( request == null ) {
            return animal;
        }

        animal.setName( request.getName() );
        animal.setSpecies( request.getSpecies() );
        if ( request.getAge() != null ) {
            animal.setAge( request.getAge() );
        }

        return animal;
    }
}
