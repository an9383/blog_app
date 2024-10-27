package org.sb0907.blogapp.dto;

import lombok.Getter;
import org.sb0907.blogapp.domain.Article;

@Getter
public class ArticleResponse {

    private final String title;
    private final String content;

    // 엔터티를 인수를 가지는 생성자
    public ArticleResponse(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }

}
