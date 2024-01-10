package dev.hissdev.contentcalendar.controller;

import dev.hissdev.contentcalendar.model.Content;
import dev.hissdev.contentcalendar.model.Status;
import dev.hissdev.contentcalendar.repository.ContentRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
// путь до контроллера
@RequestMapping("/api/content")
// Включает подключение к некоторым портам
@CrossOrigin
public class ContentController {

    private final ContentRepository repository;

    public ContentController(ContentRepository repository) {
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

//    @Valid сообщает, что перед выполнением тела функции параметр должен быть провалидирован
    public void create(@Valid @RequestBody Content content) {
        repository.save(content);
    }

//    Метод обновления
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id) {

        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Запрашиваемый ресурс не найден.");
        }
        repository.save(content);

    }

//    Удаление контента
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

//    Поиск поста по заголовку
    @GetMapping("/filter/{keyword}")
    public List<Content> findByTitle(@PathVariable String keyword) {
        return repository.findAllByTitleContains(keyword);
    }

//    Поиск по статусу
    @GetMapping("/filter/status/{status}")
    public List<Content> findByStatus(@PathVariable Status status) {
        return repository.listByStatus(status);
    }


}
