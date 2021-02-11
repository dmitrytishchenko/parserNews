package ru.job4j.parserNews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.parserNews.model.News;
@Repository
public interface Storage extends JpaRepository<News, Long> {
}
