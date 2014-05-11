package com.epam.articleweb.articleservice;


import com.epam.articleweb.Article;
import com.epam.articleweb.articlesdao.ArticlesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticlesService {
    @Autowired
    private ArticlesDao articlesDao;

    public void add(Article article) {
        articlesDao.add(article);
    }

    public void delete(long id) {
        articlesDao.delete(id);
    }

    public List<Article> getArticles() {
        return articlesDao.list();
    }
}
