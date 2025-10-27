package ru.neoflex.ru.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Базовый класс для человека")
public class Person {
    
    @Schema(description = "Имя", example = "Александр")
    private String firstName;
    
    @Schema(description = "Отчество", example = "Михайлович")
    private String middleName;
    
    @Schema(description = "Фамилия", example = "Опекушин")
    private String lastName;
    
    @Schema(description = "Возраст", example = "85")
    private Integer age;
    
    @Schema(description = "Место рождения", example = "с. Свечкино, Ярославская губерния")
    private String placeOfBirth;
    
    @Schema(description = "Дата рождения", example = "1838-11-28")
    private String dateOfBirth;
    
    @Schema(description = "Национальность", example = "Русский")
    private String nationality;
    
    @Schema(description = "Пол", example = "Мужской")
    private String gender;
}
