package ru.neoflex.ru.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import java.util.Date;

@Data
@Entity
public class MonumentExpertEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_monument_expert_evaluation")
    private Long id;
    private String evaluatorName;
    private String monumentName;
    private String conditionDescription;
    private Integer rating;
    private Date evaluationDate;
    private String recommendations;
    @OneToOne(mappedBy = "monumentExpertEvaluation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Monument monument;

}
