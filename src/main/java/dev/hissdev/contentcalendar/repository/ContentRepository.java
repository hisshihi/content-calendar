package dev.hissdev.contentcalendar.repository;

import dev.hissdev.contentcalendar.model.Content;
import dev.hissdev.contentcalendar.model.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {

//    Пользовательские запросы
    List<Content> findAllByTitleContains(String keyword);

    @Query("""
    SELECT * FROM Content where status = :status
""")
    List<Content> listByStatus(@Param("status") Status status);

}
