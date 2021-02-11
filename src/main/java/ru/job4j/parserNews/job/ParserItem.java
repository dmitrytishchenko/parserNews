package ru.job4j.parserNews.job;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.job4j.parserNews.model.Item;
import ru.job4j.parserNews.service.ServiceForumimpl;

import java.io.IOException;

@Component
public class ParserItem {

    @Autowired
    ServiceForumimpl service;

    @Scheduled(fixedDelay = 10)
    public void parseForumSkoda() {
        String url = "https://forum.skoda-club.ru/viewforum.php?f=20";
        try {
            Document doc = Jsoup.connect(url)
                    .userAgent("Chrome")
                    .timeout(10000)
                    .referrer("https://google.com")
                    .get();
            Elements items = doc.getElementsByClass("topictitle");
            for (Element el : items) {
                String desc = el.ownText();
                if (!service.isExist(desc)) {
                    Item item = new Item();
                    item.setDescription(desc);
                    service.save(item);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
