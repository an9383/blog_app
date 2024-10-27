package org.sb0907.blogapp.controller;

import lombok.RequiredArgsConstructor;
import org.sb0907.blogapp.domain.Article;
import org.sb0907.blogapp.dto.ArticleListViewResponse;
import org.sb0907.blogapp.dto.ArticleViewResponse;
import org.sb0907.blogapp.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogViewController {
    private final BlogService blogService;

    // 글 목록 보기 (전체)
    @GetMapping("/articles")
    public String getArticles(Model model) {
        List<ArticleListViewResponse> articles = blogService.findAll().stream()
                .map(ArticleListViewResponse::new)
                .toList();
        model.addAttribute("articles", articles);
        return "articleList";
    }

    // 글 상세 보기 (1건)
    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model) {
        Article article = blogService.findById(id);
        model.addAttribute("article", new ArticleViewResponse(article));
        return "article";
    }

    // 글 등록 & 글 수정
    @GetMapping("/new-article")
    public String newArticle(@RequestParam(required = false) Long id, Model model) {
        if(id == null) { // 아이디가 없을 때 -> 글 등록
            model.addAttribute("article", new ArticleViewResponse());
        } else {         // 아이디가 있을 때 -> 글 수정
            Article article = blogService.findById(id);
            model.addAttribute("article", new ArticleViewResponse(article));
        }
        return "newArticle";
    }
}
