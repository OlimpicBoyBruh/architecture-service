package ru.neoflex.ru.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
        // Проверяем и сохраняем связанные сущности
        var savedRegion = saveOrGetRegion(monumentDto.getRegion());
        var savedCreator = saveOrGetCreator(monumentDto.getCreatorMonument());
        var savedExpertEvaluation = monumentExpertEvaluationRepository.save(monumentDto.getMonumentExpertEvaluation());
        
        // Создаем Monument с сохраненными сущностями
        var monument = Monument.builder()
                .id(monumentDto.getId())
                .type(monumentDto.getType())
                .dateCreated(monumentDto.getDateCreated())
                .creatorMonument(savedCreator)
                .description(monumentDto.getDescription())
                .region(savedRegion)
                .monumentExpertEvaluation(savedExpertEvaluation)
                .build();
                
        monumentRepository.save(monument);
    }
    
    private ru.neoflex.ru.model.entity.Region saveOrGetRegion(ru.neoflex.ru.model.entity.Region region) {
        if (region.getCode() != null) {
            return regionRepository.findById(region.getCode())
                    .orElseGet(() -> regionRepository.save(region));
        }
        return regionRepository.save(region);
    }
    
    private ru.neoflex.ru.model.entity.CreatorMonument saveOrGetCreator(ru.neoflex.ru.model.entity.CreatorMonument creator) {
        if (creator.getId() != null) {
            return creatorMonumentRepository.findById(creator.getId())
                    .orElseGet(() -> creatorMonumentRepository.save(creator));
        }
        return creatorMonumentRepository.save(creator);
    }
}
