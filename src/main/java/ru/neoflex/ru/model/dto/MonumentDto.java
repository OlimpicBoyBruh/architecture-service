package ru.neoflex.ru.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.neoflex.ru.model.entity.CreatorMonument;
import ru.neoflex.ru.model.entity.Monument;
import ru.neoflex.ru.model.entity.MonumentExpertEvaluation;
import ru.neoflex.ru.model.entity.Region;
import ru.neoflex.ru.model.enumerated.MonumentType;
import java.util.Date;

/**
 * DTO for {@link Monument}
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Данные памятника истории и архитектуры")
public class MonumentDto {
    @Schema(description = "Уникальный идентификатор памятника", example = "1")
    private Integer id;
    
    @Schema(description = "Информация о создателе памятника")
    private CreatorMonument creatorMonument;
    
    @Schema(description = "Регион расположения памятника")
    private Region region;
    
    @Schema(description = "Тип памятника", example = "STATUE")
    private MonumentType type;
    
    @Schema(description = "Экспертная оценка состояния памятника")
    private MonumentExpertEvaluation monumentExpertEvaluation;
    
    @Schema(description = "Описание памятника", example = "Памятник Александру Сергеевичу Пушкину на Пушкинской площади")
    private String description;
    
    @Schema(description = "Дата создания памятника", example = "2024-01-15T10:30:00.000Z")
    private Date dateCreated;
}