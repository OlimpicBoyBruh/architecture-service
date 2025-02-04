package ru.neoflex.ru.mapper;

import ru.neoflex.ru.model.entity.Monument;
import ru.neoflex.ru.model.dto.MonumentDto;

public class MonumentMapper {

    public static MonumentDto toDto(Monument monument) {
        return MonumentDto.builder()
                .id(monument.getId())
                .type(monument.getType())
                .dateCreated(monument.getDateCreated())
                .creatorMonument(monument.getCreatorMonument())
                .description(monument.getDescription())
                .region(monument.getRegion())
                .monumentExpertEvaluation(monument.getMonumentExpertEvaluation())
                .build();

    }

    public static Monument toEntity(MonumentDto monumentDto) {
        return Monument.builder()
                .id(monumentDto.getId())
                .type(monumentDto.getType())
                .dateCreated(monumentDto.getDateCreated())
                .creatorMonument(monumentDto.getCreatorMonument())
                .description(monumentDto.getDescription())
                .region(monumentDto.getRegion())
                .monumentExpertEvaluation(monumentDto.getMonumentExpertEvaluation())
                .build();
    }
}
