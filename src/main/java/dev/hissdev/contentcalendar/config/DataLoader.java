package dev.hissdev.contentcalendar.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

// Эти данные будут загружаться только когда активный профиль равен dev
//@Profile("dev")
//@Component
public class DataLoader implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello 👻");
    }
}
