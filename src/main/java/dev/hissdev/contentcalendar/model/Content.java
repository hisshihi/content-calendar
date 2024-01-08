package dev.hissdev.contentcalendar.model;

import java.time.LocalDateTime;

// Это класс с уже предопределёнными методами, в части с конструктором
public record Content(
        Integer id,
        String title,
        String desc,
        Status status,
        Type contentType,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String url
) {
}
