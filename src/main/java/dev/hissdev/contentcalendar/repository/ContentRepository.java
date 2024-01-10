package dev.hissdev.contentcalendar.repository;

import dev.hissdev.contentcalendar.model.Content;
import org.springframework.data.repository.ListCrudRepository;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {
}
