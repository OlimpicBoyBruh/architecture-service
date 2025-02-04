package ru.neoflex.ru.controller;

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
public class ArchitectureController {
    private final ArchitectureService architectureService;

    @PostMapping("/save")
    public void saveArchitecture(@RequestBody MonumentDto monumentDto) {
       architectureService.saveMonument(monumentDto);
    }

    @GetMapping("/get")
    public List<Monument> getArchitectures() {
        return architectureService.findArchitectures();
    }
}
