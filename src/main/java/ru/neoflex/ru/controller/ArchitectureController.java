package ru.neoflex.ru.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.neoflex.ru.model.entity.Monument;
import ru.neoflex.ru.model.dto.MonumentDto;
import ru.neoflex.ru.service.ArchitectureService;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/architecture")
@RequiredArgsConstructor
@Tag(name = "Архитектурные памятники", description = "API для управления сведениями о памятниках истории и архитектуры")
public class ArchitectureController {
    private final ArchitectureService architectureService;

    @Operation(
        summary = "Сохранение памятника",
        description = "Создает новый памятник истории и архитектуры с полной информацией о создателе, регионе и экспертной оценке"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Памятник успешно сохранен",
        content = @Content(mediaType = "application/json")
    )
    @PostMapping("/save")
    public void saveArchitecture(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Данные памятника для сохранения",
            required = true,
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = MonumentDto.class),
                examples = @ExampleObject(
                    name = "Пример памятника",
                    summary = "Памятник Пушкину в Москве",
                    value = """
                    {
                      "type": "STATUE",
                      "description": "Памятник Александру Сергеевичу Пушкину на Пушкинской площади",
                      "dateCreated": "2024-01-15T10:30:00.000Z",
                      "creatorMonument": {
                        "firstName": "Александр",
                        "middleName": "Михайлович",
                        "lastName": "Опекушин",
                        "dateOfBirth": "1838-11-28"
                      },
                      "region": {
                        "code": 77,
                        "name": "Москва"
                      },
                      "monumentExpertEvaluation": {
                        "evaluatorName": "Иванов Иван Иванович",
                        "monumentName": "Памятник А.С. Пушкину",
                        "conditionDescription": "Отличное состояние, требует регулярной очистки",
                        "rating": 9,
                        "evaluationDate": "2024-01-10T14:00:00.000Z",
                        "recommendations": "Проводить ежегодную реставрацию"
                      }
                    }
                    """
                )
            )
        )
        @RequestBody MonumentDto monumentDto
    ) {
       architectureService.saveMonument(monumentDto);
    }

    @Operation(
        summary = "Получение всех памятников",
        description = "Возвращает список всех памятников истории и архитектуры с полной информацией"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Список памятников успешно получен",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = Monument.class),
            examples = @ExampleObject(
                name = "Пример списка памятников",
                summary = "Список памятников",
                value = """
                [
                  {
                    "id": 1,
                    "type": "STATUE",
                    "description": "Памятник Александру Сергеевичу Пушкину на Пушкинской площади",
                    "dateCreated": "2024-01-15T10:30:00.000Z",
                    "creatorMonument": {
                      "id": 1,
                      "firstName": "Александр",
                      "middleName": "Михайлович",
                      "lastName": "Опекушин",
                      "dateOfBirth": "1838-11-28"
                    },
                    "region": {
                      "code": 77,
                      "name": "Москва"
                    },
                    "monumentExpertEvaluation": {
                      "id": 1,
                      "evaluatorName": "Иванов Иван Иванович",
                      "monumentName": "Памятник А.С. Пушкину",
                      "conditionDescription": "Отличное состояние, требует регулярной очистки",
                      "rating": 9,
                      "evaluationDate": "2024-01-10T14:00:00.000Z",
                      "recommendations": "Проводить ежегодную реставрацию"
                    }
                  },
                  {
                    "id": 2,
                    "type": "BUST",
                    "description": "Бюст Льва Николаевича Толстого в Ясной Поляне",
                    "dateCreated": "2024-01-20T09:15:00.000Z",
                    "creatorMonument": {
                      "id": 2,
                      "firstName": "Сергей",
                      "middleName": "Дмитриевич",
                      "lastName": "Меркуров",
                      "dateOfBirth": "1881-10-26"
                    },
                    "region": {
                      "code": 71,
                      "name": "Тульская область"
                    },
                    "monumentExpertEvaluation": {
                      "id": 2,
                      "evaluatorName": "Петрова Мария Сергеевна",
                      "monumentName": "Бюст Л.Н. Толстого",
                      "conditionDescription": "Хорошее состояние, незначительные следы выветривания",
                      "rating": 8,
                      "evaluationDate": "2024-01-18T11:30:00.000Z",
                      "recommendations": "Очистка от загрязнений раз в полгода"
                    }
                  }
                ]
                """
            )
        )
    )
    @GetMapping("/get")
    public List<Monument> getArchitectures() {
        return architectureService.findArchitectures();
    }
}
