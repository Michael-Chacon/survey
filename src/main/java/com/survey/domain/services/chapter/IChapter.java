package com.survey.domain.services.chapter;

import com.survey.persistence.entities.Chapter;

import java.util.List;
import java.util.Optional;

public interface IChapter {
    List<Chapter> findAll();
    Optional<Chapter> findById(Long id);
    Chapter save(Chapter chapter);
    Optional<Chapter> update(Long id, Chapter chapter);
    Optional<Chapter> delete(Long id);
}
