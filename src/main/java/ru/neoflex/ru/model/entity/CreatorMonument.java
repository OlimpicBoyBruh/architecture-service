package ru.neoflex.ru.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Создатель памятника")
public class CreatorMonument extends Person {
    @Id
    @SequenceGenerator(name = "creator_monument_id_seq_gen", sequenceName = "creator_monument_id_seq", allocationSize = 50)
    @GeneratedValue(generator = "creator_monument_id_seq_gen", strategy = GenerationType.SEQUENCE)
    @Schema(description = "Уникальный идентификатор создателя", example = "1")
    private Long id;
    
    @OneToMany(mappedBy = "creatorMonument", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    @Schema(description = "Список памятников, созданных этим автором")
    private List<Monument> monuments;

}