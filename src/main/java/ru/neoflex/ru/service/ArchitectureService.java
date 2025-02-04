package ru.neoflex.ru.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.neoflex.ru.mapper.MonumentMapper;
import ru.neoflex.ru.model.dto.MonumentDto;
import ru.neoflex.ru.model.entity.Monument;
import ru.neoflex.ru.repository.CreatorMonumentRepository;
import ru.neoflex.ru.repository.MonumentExpertEvaluationRepository;
import ru.neoflex.ru.repository.MonumentRepository;
import ru.neoflex.ru.repository.RegionRepository;
import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class ArchitectureService {
    private final MonumentRepository monumentRepository;
    private final RegionRepository regionRepository;
    private final CreatorMonumentRepository creatorMonumentRepository;
    private final MonumentExpertEvaluationRepository monumentExpertEvaluationRepository;

    public List<Monument> findArchitectures() {
        return monumentRepository.findAll();
    }
    @Transactional
    public void saveMonument(MonumentDto monumentDto) {
        monumentExpertEvaluationRepository.save(monumentDto.getMonumentExpertEvaluation());
        regionRepository.save(monumentDto.getRegion());
        creatorMonumentRepository.save(monumentDto.getCreatorMonument());
        monumentRepository.save(MonumentMapper.toEntity(monumentDto));
    }
}
