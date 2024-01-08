package dev.hissdev.contentcalendar.repository;

import dev.hissdev.contentcalendar.model.Content;
import org.springframework.stereotype.Repository;

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

}
