package ru.job4j.parserNews.service;

import ru.job4j.parserNews.model.Item;

import java.util.List;

public interface ForumService {
    void save(Item item);
    boolean isExist(String desc);
    List<Item> getAllItem();
}
