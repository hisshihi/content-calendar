package dev.hissdev.contentcalendar.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/*
* @Configuration: Это аннотация,
*  которая указывает на то, что этот класс является конфигурационным для Spring.
* */
@Configuration
public class MyWebConfig {

    /*
    * @Bean: Эта аннотация указывает,
    * что метод restTemplate() возвращает объект, который Spring должен управлять в контейнере IoC как бин.
    * */
    @Bean
    /*
    * RestTemplate: Это класс из библиотеки Spring Framework,
    *  который предоставляет простой способ взаимодействия с веб-службами REST.
    *  Он может использоваться для отправки HTTP-запросов и получения HTTP-ответов.
    * */
    public RestTemplate restTemplate() {
        /*
        * restTemplate(): Это метод, который создает и возвращает экземпляр RestTemplate с помощью RestTemplateBuilder.
        *  RestTemplateBuilder - это класс из Spring, предназначенный для создания экземпляров RestTemplate с предварительной настройкой.
        * */
        return new RestTemplateBuilder().build();
    }

}
