package dev.hissdev.contentcalendar.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.hissdev.contentcalendar.model.Content;
import dev.hissdev.contentcalendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

// Эти данные будут загружаться только когда активный профиль равен dev
//@Profile("dev")
@Component
public class DataLoader implements CommandLineRunner {

    //    Создаём хранилище данных для дальнейшей загрузки в бд
    private final ContentRepository contentRepository;
    //    Отображение объектов json
    private final ObjectMapper objectMapper;

    public DataLoader(ContentRepository contentRepository, ObjectMapper objectMapper) {
        this.contentRepository = contentRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/content.json")) {
            contentRepository.saveAll(objectMapper.readValue(inputStream, new TypeReference<List<Content>>(){}));
        }
    }
}
