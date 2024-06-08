package org.example.schroniskozwierzat;

import io.swagger.client.api.AnimalApi;

import io.swagger.client.model.AnimalRequest;
import io.swagger.client.model.AnimalResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/animals")
@Validated
public class AnimalController extends AnimalApi {
    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public ResponseEntity<List<AnimalResponse>> getAllAnimals() {
        return animalService.getAllAnimals();
    }

    @GetMapping("/{id}")
    public AnimalResponse getAnimalById(@PathVariable UUID id) {
        return animalService.getAnimalById(id);
    }

    @PostMapping
    public ResponseEntity<AnimalResponse> createAnimal(@RequestBody @Valid AnimalRequest animalRequest) {
        return animalService.saveAnimal(animalRequest);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @PutMapping("/{id}")
    public ResponseEntity<AnimalResponse> updateAnimal(@PathVariable UUID id, @RequestBody AnimalRequest animalRequest) {
        return animalService.updateAnimal(id, animalRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable UUID id) {
        return animalService.deleteAnimal(id);
    }
}