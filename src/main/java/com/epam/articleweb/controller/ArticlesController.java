package com.epam.articleweb.controller;

import com.epam.articleweb.Article;
import com.epam.articleweb.articleservice.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ArticlesController {
    private static final String LIST_PAGE = "list";
    private static final String ADD_PAGE = "add";

    private static final String ARTICLES_ATTR = "articles";
    private static final String ARTICLE_ATTR = "article";

    @Autowired
    private ArticlesService articlesService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(ARTICLE_ATTR, new Article());
        return ADD_PAGE;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute(ARTICLE_ATTR) Article article, Model model) {
        articlesService.add(article);
        model.addAttribute(ARTICLES_ATTR, articlesService.getArticles());
        return LIST_PAGE;
    }

    @RequestMapping(value = {"/list" , "/"}, method = RequestMethod.GET)
    public String list(Model model) {
        List<Article> articles = articlesService.getArticles();
        model.addAttribute(ARTICLES_ATTR, articles);
        return LIST_PAGE;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") long id, Model model) {
        articlesService.delete(id);
        model.addAttribute(ARTICLES_ATTR, articlesService.getArticles());
        return LIST_PAGE;
    }
}
