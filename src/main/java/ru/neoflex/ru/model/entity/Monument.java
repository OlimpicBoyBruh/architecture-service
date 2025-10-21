package ru.neoflex.ru.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.neoflex.ru.model.enumerated.MonumentType;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Памятник истории и архитектуры")
public class Monument {
    @Id
    @SequenceGenerator(name = "monument_id_seq_gen", sequenceName = "monument_id_seq", allocationSize = 50)
    @GeneratedValue(generator = "monument_id_seq_gen", strategy = GenerationType.SEQUENCE)
    @Schema(description = "Уникальный идентификатор памятника", example = "1")
    private Integer id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "creator_monument_id")
    @Schema(description = "Создатель памятника")
    private CreatorMonument creatorMonument;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "regioncode", referencedColumnName = "code")
    @Schema(description = "Регион расположения памятника")
    private Region region;
    
    @Enumerated(EnumType.STRING)
    @Schema(description = "Тип памятника", example = "STATUE")
    private MonumentType type;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "expert_monument_id")
    @Schema(description = "Экспертная оценка состояния памятника")
    private MonumentExpertEvaluation monumentExpertEvaluation;
    
    @Schema(description = "Описание памятника", example = "Памятник Александру Сергеевичу Пушкину на Пушкинской площади")
    private String description;
    
    @Schema(description = "Дата создания памятника", example = "2024-01-15T10:30:00.000Z")
    private Date dateCreated;
}
