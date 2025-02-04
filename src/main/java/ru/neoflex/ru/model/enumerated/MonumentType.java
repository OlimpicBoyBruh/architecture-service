package ru.neoflex.ru.model.enumerated;

public enum MonumentType {
    MEMORIAL_STONE("Памятный камень"),
    CROSS("Крест"),
    BUST("Бюст"),
    STATUE("Статуя"),
    EQUESTRIAN_STATUE("Конная статуя"),
    TRIUMPHS_ARCH("Триумфальная арка"),
    OBELISK("Обелиск"),
    ROSTRAL_COLUMN("Ростральная колонна"),
    TRIUMPHS_COLUMN("Триумфальная колонна"),
    TROPHIES("Трофеи"),
    CENOTAPH("Кенотаф"),
    ABSTRACT_COMPOSITION("Абстрактная композиция"),
    MEMORIAL_SIGN("Памятный знак"),
    PLAQUE("Памятная доска"),
    TECHNICAL_MONUMENTS("Технические памятники"),
    MEMORIAL_COMPLEXES("Мемориальные комплексы"),
    PYRAMIDS("Пирамиды");

    private final String description;

    MonumentType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
