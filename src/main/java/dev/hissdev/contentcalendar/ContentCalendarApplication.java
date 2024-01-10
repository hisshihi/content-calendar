package dev.hissdev.contentcalendar;

import dev.hissdev.contentcalendar.model.Content;
import dev.hissdev.contentcalendar.model.Status;
import dev.hissdev.contentcalendar.model.Type;
import dev.hissdev.contentcalendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class ContentCalendarApplication {

	public static void main(String[] args) {

		SpringApplication.run(ContentCalendarApplication.class, args);

	}

	@Bean
	CommandLineRunner commandLineRunner(ContentRepository contentRepository) {
		return args -> {
//				Вставка некоторых данных из бд
			Content content = new Content(null,
					"Hello Chat GPT",
					"This video tell you about chat gpt",
					Status.IDEA,
					Type.VIDEO,
					LocalDateTime.now(),
					null,
					""
			);

			contentRepository.save(content);

		};
	}

}
