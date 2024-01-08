package dev.hissdev.contentcalendar.controller;

import dev.hissdev.contentcalendar.model.Content;
import dev.hissdev.contentcalendar.repository.ContentCollectionRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

}
