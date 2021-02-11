package ru.job4j.parserNews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.parserNews.model.Item;
import ru.job4j.parserNews.repository.StorageForum;

import java.util.List;
import java.util.Optional;
@Service
public class ServiceForumimpl implements ForumService {

    @Autowired
    StorageForum storage;

    @Override
    public void save(Item item) {
        storage.save(item);
    }

    @Override
    public boolean isExist(String desc) {
        Optional<Item> item = storage.findAll().stream().filter(n -> n.getDescription().equals(desc)).findFirst();
        if (item.isPresent()) {
            return true;
        }
        return false;
    }

    @Override
    public List<Item> getAllItem() {
        return storage.findAll();
    }
}
