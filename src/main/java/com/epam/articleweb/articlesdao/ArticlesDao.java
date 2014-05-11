package com.epam.articleweb.articlesdao;

import com.epam.articleweb.Article;

import java.util.List;


public interface ArticlesDao {
    void add(Article article);

    void delete(long id);

    List<Article> list();
}
