package ru.neoflex.ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.neoflex.ru.model.entity.Monument;

@Repository
public interface MonumentRepository extends JpaRepository<Monument, Integer> {

}
