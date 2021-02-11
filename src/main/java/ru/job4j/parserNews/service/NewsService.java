package ru.job4j.parserNews.service;

import org.springframework.stereotype.Service;
import ru.job4j.parserNews.model.News;

import java.util.List;

@Service
public interface NewsService {
    void save(News news);
    boolean isExist(String title);
    List<News> getAllNews();
}
