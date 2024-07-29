package com.survey;

import com.survey.domain.repository.ChapterRepository;
import com.survey.domain.repository.SurveyRepository;
import com.survey.persistence.entities.Chapter;
import com.survey.persistence.entities.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SurveyApplication implements CommandLineRunner {
	@Autowired
	private SurveyRepository surveyRepository;

	@Autowired
	private ChapterRepository chapterRepository;

	public static void main(String[] args) {
		SpringApplication.run(SurveyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		surveyChapter();
	}
	public void surveyChapter(){
		Survey survey = new Survey("prueba", "lorem lorem lorem ", new Date(), new Date());
		surveyRepository.save(survey);
		Chapter chapter = new Chapter("01", "relations with spring");
		Chapter chapter1 = new Chapter("02", "ManyToOne");
		chapter.setSurvey(survey);
		chapter1.setSurvey(survey);
		chapterRepository.save(chapter1);
		chapterRepository.save(chapter);
	}
}
