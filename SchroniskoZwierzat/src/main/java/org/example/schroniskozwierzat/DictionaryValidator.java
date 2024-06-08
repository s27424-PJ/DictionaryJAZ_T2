package org.example.schroniskozwierzat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.stream.Collectors;

public class DictionaryValidator implements ConstraintValidator<ValidateAnimalType, String> {

    @Autowired
    private ApplicationContext applicationContext;

    private AnimalTypeRepository animalTypeRepository;

    @Override
    public void initialize(ValidateAnimalType constraintAnnotation) {
        this.animalTypeRepository = applicationContext.getBean(AnimalTypeRepository.class);
    }

    @Override
    public boolean isValid(String animalType, ConstraintValidatorContext constraintValidatorContext) {
        if (animalType == null) {
            return true;
        }

        List<String> animalTypesFromDB = animalTypeRepository.findAll().stream()
                .map(AnimalType::getType)
                .collect(Collectors.toList());
        return animalTypesFromDB.contains(animalType);
    }
}
