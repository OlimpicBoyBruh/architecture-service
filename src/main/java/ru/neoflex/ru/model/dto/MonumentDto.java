package ru.neoflex.ru.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class MonumentDto {
    private Integer id;
    private CreatorMonument creatorMonument;
    private Region region;
    private MonumentType type;
    private MonumentExpertEvaluation monumentExpertEvaluation;
    private String description;
    private Date dateCreated;
}