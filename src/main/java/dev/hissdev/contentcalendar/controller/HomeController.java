package dev.hissdev.contentcalendar.controller;

import dev.hissdev.contentcalendar.config.ContentCalendarProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final ContentCalendarProperties properties;

    public HomeController(ContentCalendarProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/")
    public ContentCalendarProperties hello() {
        return properties;
    }

}
