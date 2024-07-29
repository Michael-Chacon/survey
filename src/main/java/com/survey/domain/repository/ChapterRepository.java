package com.survey.domain.repository;

import com.survey.persistence.entities.Chapter;
import org.springframework.data.repository.CrudRepository;

public interface ChapterRepository extends CrudRepository<Chapter, Long> {
}
