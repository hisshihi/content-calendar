package dev.hissdev.contentcalendar.repository;

import dev.hissdev.contentcalendar.model.Content;
import dev.hissdev.contentcalendar.model.Status;
import dev.hissdev.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Помечаем класс как хранилище, чтобы временно хранить данные
@Repository
public class ContentCollectionRepository {

//    Хранилище данных
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        return contentList;
    }

//    Поиск по одному объекту, Option означает что этот метод может существовать а может и отсутствовать
    public Optional<Content> findById(Integer id) {
//        Поиск по id и возврат первого совпадения
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

//    Инициализаця для отправки данных по api
    @PostConstruct
    public void init() {
        Content c = new Content(1,
                "My firs post in a blog",
                "Hello, this is my first post!",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                ""
                );
        contentList.add(c);
    }

}
