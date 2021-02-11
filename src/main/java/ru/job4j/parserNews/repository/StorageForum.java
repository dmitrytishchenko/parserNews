package ru.job4j.parserNews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.parserNews.model.Item;

public interface StorageForum extends JpaRepository<Item, Long> {
}
