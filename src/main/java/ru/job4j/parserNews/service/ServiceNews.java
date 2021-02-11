package ru.job4j.parserNews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ru.job4j.parserNews.model.News;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceNews implements NewsService {
    @Autowired
    private JpaRepository store;


    @Override
    public void save(News news) {
        store.save(news);
    }

    @Override
    public boolean isExist(String title) {
        boolean result = false;
        Optional<News> copy = getAllNews().stream().filter(it -> it.getTitle().equals(title)).findAny();
        if (copy.isPresent()) {
            result = true;
        }
        return result;
    }

    @Override
    public List<News> getAllNews() {
        return store.findAll();
    }
}
