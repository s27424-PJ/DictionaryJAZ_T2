package org.example.schroniskozwierzat;


import io.swagger.client.api.AnimalApi;
import io.swagger.client.model.AnimalRequest;
import io.swagger.client.model.AnimalResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AnimalService extends AnimalApi {
    private final AnimalRepository animalRepository;
    private final AnimalMapper animalMapper;

    @Autowired
    public AnimalService(AnimalRepository animalRepository, AnimalMapper animalMapper) {
        this.animalRepository = animalRepository;
        this.animalMapper = animalMapper;
    }

    public ResponseEntity<List<AnimalResponse>> getAllAnimals() {
        List<AnimalResponse> foundAnimals = animalRepository.findAll().stream()
                .map(animalMapper::mapEntityToResponse)
                .collect(Collectors.toList());

        if (foundAnimals.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(foundAnimals, HttpStatus.OK);
    }

    public AnimalResponse getAnimalById(UUID id) {
        Animal animal = animalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Animal not found with id: " + id));
        return new ResponseEntity<>(animalMapper.mapEntityToResponse(animal), HttpStatus.OK).getBody();
    }
@Transactional
    public ResponseEntity<AnimalResponse> saveAnimal(AnimalRequest createRequest) {
        Animal animal = animalMapper.mapToAnimal(createRequest);
        Animal savedAnimal = animalRepository.save(animal);
        return new ResponseEntity<>(animalMapper.mapEntityToResponse(savedAnimal), HttpStatus.OK);
    }

    public ResponseEntity<AnimalResponse> updateAnimal(UUID id, AnimalRequest updateRequest) {
        Animal animal = animalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Animal not found with id: " + id));

        Animal updatedAnimal = animalMapper.update(updateRequest, animal);
        return new ResponseEntity<>(animalMapper.mapEntityToResponse(animalRepository.save(updatedAnimal)), HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteAnimal(UUID id) {
        Animal animal = animalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Animal not found with id: " + id));

        animalRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}