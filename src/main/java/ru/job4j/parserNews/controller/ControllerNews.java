package ru.job4j.parserNews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.parserNews.model.News;
import ru.job4j.parserNews.service.ServiceNews;

import java.util.List;

@RestController
public class ControllerNews {
    @Autowired
    ServiceNews service;

    @GetMapping(value = "/news")
    public List<News> getAllNews() {
        return service.getAllNews();
    }
}
