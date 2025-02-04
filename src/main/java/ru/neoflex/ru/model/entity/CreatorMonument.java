package ru.neoflex.ru.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class CreatorMonument {
    @Id
    @GeneratedValue(generator = "creatorMonument_id_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String dateOfBirth;
    @OneToMany(mappedBy = "creatorMonument", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Monument> monuments;

}