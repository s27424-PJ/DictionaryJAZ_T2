package org.example.schroniskozwierzat;


import io.swagger.client.model.AnimalRequest;
import io.swagger.client.model.AnimalResponse;
import org.mapstruct.*;


@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface AnimalMapper {

    @Mapping(target = "id", ignore = true)
    Animal mapToAnimal(AnimalRequest request);

    AnimalResponse mapEntityToResponse(Animal entity);

    @Mapping(target = "id", ignore = true)
    Animal update(AnimalRequest request, @MappingTarget Animal animal);
}

