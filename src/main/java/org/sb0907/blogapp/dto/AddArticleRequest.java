package org.sb0907.blogapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sb0907.blogapp.domain.Article;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {

    private String title;

    private String content;

    // 빌더 패턴을 사용한 객체 생성 메서드
    public Article toEntity() {
        return Article.builder().title(title).content(content).build();
    }
}
