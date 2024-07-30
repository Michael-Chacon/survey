package com.survey;

import com.survey.domain.repository.ChapterRepository;
import com.survey.domain.repository.SurveyRepository;
import com.survey.persistence.entities.Chapter;
import com.survey.persistence.entities.Response;
import com.survey.persistence.entities.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;
import java.util.Set;

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
		surveyResponses();
	}

	public void surveyResponses(){
		Optional<Survey> survey = surveyRepository.findOne(3L);
		survey.ifPresent(s-> {
			s.addResponses(new Response("A", LocalTime.now(), new Date())).addResponses(new Response("B", LocalTime.now(), new Date()));
			surveyRepository.save(s);
			System.out.println(s);
		});
	}

	public void surveyChapter(){
		Survey survey = new Survey("prueba", "lorem lorem lorem ", new Date(), new Date());
		Chapter chapter = new Chapter("01", "relations with spring");
		Chapter chapter1 = new Chapter("02", "ManyToOne");
		survey.addChapter(chapter).addChapter(chapter1);
		surveyRepository.save(survey);
//		chapter.setSurvey(survey);
//		chapter1.setSurvey(survey);
//		chapterRepository.save(chapter1);
//		chapterRepository.save(chapter);
//		System.out.println(survey);
	}
}
