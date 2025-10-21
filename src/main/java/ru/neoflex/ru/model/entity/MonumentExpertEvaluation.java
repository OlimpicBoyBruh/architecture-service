package ru.neoflex.ru.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Schema(description = "Экспертная оценка состояния памятника")
public class MonumentExpertEvaluation {
    @Id
    @SequenceGenerator(name = "seq_monument_expert_evaluation_gen", sequenceName = "seq_monument_expert_evaluation", allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_monument_expert_evaluation_gen")
    @Schema(description = "Уникальный идентификатор оценки", example = "1")
    private Long id;
    
    @Schema(description = "ФИО эксперта", example = "Иванов Иван Иванович")
    private String evaluatorName;
    
    @Schema(description = "Название памятника", example = "Памятник А.С. Пушкину")
    private String monumentName;
    
    @Schema(description = "Описание состояния памятника", example = "Отличное состояние, требует регулярной очистки")
    private String conditionDescription;
    
    @Schema(description = "Оценка состояния (1-10)", example = "9")
    private Integer rating;
    
    @Schema(description = "Дата проведения оценки", example = "2024-01-10T14:00:00.000Z")
    private Date evaluationDate;
    
    @Schema(description = "Рекомендации по уходу", example = "Проводить ежегодную реставрацию")
    private String recommendations;
    
    @OneToOne(mappedBy = "monumentExpertEvaluation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    @Schema(description = "Памятник, к которому относится оценка")
    private Monument monument;

}
