package ru.neoflex.ru.model.enumerated;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Типы памятников истории и архитектуры")
public enum MonumentType {
    @Schema(description = "Памятный камень")
    MEMORIAL_STONE("Памятный камень"),
    
    @Schema(description = "Крест")
    CROSS("Крест"),
    
    @Schema(description = "Бюст")
    BUST("Бюст"),
    
    @Schema(description = "Статуя")
    STATUE("Статуя"),
    
    @Schema(description = "Конная статуя")
    EQUESTRIAN_STATUE("Конная статуя"),
    
    @Schema(description = "Триумфальная арка")
    TRIUMPHS_ARCH("Триумфальная арка"),
    
    @Schema(description = "Обелиск")
    OBELISK("Обелиск"),
    
    @Schema(description = "Ростральная колонна")
    ROSTRAL_COLUMN("Ростральная колонна"),
    
    @Schema(description = "Триумфальная колонна")
    TRIUMPHS_COLUMN("Триумфальная колонна"),
    
    @Schema(description = "Трофеи")
    TROPHIES("Трофеи"),
    
    @Schema(description = "Кенотаф")
    CENOTAPH("Кенотаф"),
    
    @Schema(description = "Абстрактная композиция")
    ABSTRACT_COMPOSITION("Абстрактная композиция"),
    
    @Schema(description = "Памятный знак")
    MEMORIAL_SIGN("Памятный знак"),
    
    @Schema(description = "Памятная доска")
    PLAQUE("Памятная доска"),
    
    @Schema(description = "Технические памятники")
    TECHNICAL_MONUMENTS("Технические памятники"),
    
    @Schema(description = "Мемориальные комплексы")
    MEMORIAL_COMPLEXES("Мемориальные комплексы"),
    
    @Schema(description = "Пирамиды")
    PYRAMIDS("Пирамиды");

    private final String description;

    MonumentType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
