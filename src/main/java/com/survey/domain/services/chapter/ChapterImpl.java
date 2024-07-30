package com.survey.domain.services.chapter;

import com.survey.domain.repository.ChapterRepository;
import com.survey.persistence.entities.Chapter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ChapterImpl implements IChapter{
    @Autowired
    private ChapterRepository repository;

    @Override
    public List<Chapter> findAll() {
        return (List<Chapter>) repository.findAll();
    }

    @Override
    public Optional<Chapter> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Chapter save(Chapter chapter) {
        return repository.save(chapter);
    }

    @Override
    public Optional<Chapter> update(Long id, Chapter chapter) {
        Optional<Chapter> getChapter = repository.findById(id);
        if (getChapter.isPresent()){
            Chapter newChapter = getChapter.orElseThrow();
            newChapter.setChapterNumber(chapter.getChapterNumber());
            newChapter.setChapterTitle(chapter.getChapterTitle());
            newChapter.setSurvey(chapter.getSurvey());
            return Optional.of(repository.save(newChapter));
        }
        return getChapter;
    }

    @Override
    public Optional<Chapter> delete(Long id) {
        Optional<Chapter> getChapter = repository.findById(id);
        getChapter.ifPresent(chapter -> {
            repository.delete(chapter);
        });
        return getChapter;
    }
}