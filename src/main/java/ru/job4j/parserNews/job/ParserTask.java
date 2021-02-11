package ru.job4j.parserNews.job;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.job4j.parserNews.model.News;
import ru.job4j.parserNews.service.ServiceNews;

import java.io.IOException;

@Component
public class ParserTask {
    @Autowired
    ServiceNews service;

    @Scheduled(fixedDelay = 10000)
    public void parseNewNews() {
String url = "https://news.ycombinator.com/";
        try {
            Document doc = Jsoup.connect(url)
                    .userAgent("Chrome")
                    .timeout(5000)
                    .referrer("https://google.com")
                    .get();
            Elements news = doc.getElementsByClass("storylink");
            for (Element el : news) {
                String title = el.ownText();
                if (!service.isExist(title)) {
                    News news1 = new News();
                    news1.setTitle(title);
                    service.save(news1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
