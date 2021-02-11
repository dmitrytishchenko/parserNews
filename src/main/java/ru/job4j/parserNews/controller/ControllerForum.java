package ru.job4j.parserNews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.parserNews.model.Item;
import ru.job4j.parserNews.service.ServiceForumimpl;

import java.util.List;

@RestController
public class ControllerForum {
    @Autowired
    ServiceForumimpl serviceForumimpl;

    @GetMapping(value = "/forum")
    public List<Item> getAllItems() {
        return serviceForumimpl.getAllItem();
    }
}
