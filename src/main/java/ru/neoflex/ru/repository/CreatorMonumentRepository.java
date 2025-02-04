package ru.neoflex.ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.neoflex.ru.model.entity.CreatorMonument;

@Repository
public interface CreatorMonumentRepository extends JpaRepository<CreatorMonument, Long> {
}
