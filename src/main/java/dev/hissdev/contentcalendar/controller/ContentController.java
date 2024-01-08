package dev.hissdev.contentcalendar.controller;

import dev.hissdev.contentcalendar.model.Content;
import dev.hissdev.contentcalendar.repository.ContentCollectionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
// путь до контроллера
@RequestMapping("/api/content")
public class ContentController {

    private final ContentCollectionRepository repository;

    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("")
    public List<Content> findAll() {
        return repository.findAll();
    }

    @RequestMapping("/{id}")
//    @PathVariable нужен чтобы присваивать id то, что приходит в http
    public Content findById(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Запрашиваемый ресурс не найден."));
    }

//    Создание нового поста
//    Ничего не заполняем потому что при переходу по основному пути эти данные будут автоматически появляться
//    Используется аннотация post чтобы отправить новый пост

//    @ResponseStatus(HttpStatus.CREATED) отправляет статус 201

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    //    Сообщает бразузеру, что эти параметры отправляются в теле запроса
    //    То есть когда отправляется http запрос эти данные отправляются в теле
    public void create(@RequestBody Content content) {
        repository.save(content);
    }

//    Метод обновления
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id) {

        if (!repository.exsistById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Запрашиваемый ресурс не найден.");
        }
        repository.save(content);

    }

//    Удаление контента
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.delete(id);
    }

}
