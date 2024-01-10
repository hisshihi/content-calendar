package dev.hissdev.contentcalendar.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

// Это класс с уже предопределёнными методами, в части с конструктором
public record Content(
//        Эта аннотация указывает, что id является первичным ключом
        @Id
        Integer id,
//        Указывает, что это поле не должно быть пустым
        @NotBlank
        String title,
        String desc,
        Status status,
        Type contentType,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String url
) {
}
