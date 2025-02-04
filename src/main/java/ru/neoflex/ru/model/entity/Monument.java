package ru.neoflex.ru.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Monument {
    @Id
    @GeneratedValue(generator = "monument_id_seq", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "creator_monument_id")
    private CreatorMonument creatorMonument;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "regioncode", referencedColumnName = "code")
    private Region region;
    @Enumerated(EnumType.STRING)
    private MonumentType type;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "expert_monument_id")
    private MonumentExpertEvaluation monumentExpertEvaluation;
    private String description;
    private Date dateCreated;


}
