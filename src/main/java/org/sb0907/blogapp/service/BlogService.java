package org.sb0907.blogapp.service;

import lombok.RequiredArgsConstructor;
import org.sb0907.blogapp.domain.Article;
import org.sb0907.blogapp.dto.AddArticleRequest;
import org.sb0907.blogapp.dto.UpdateArticleRequest;
import org.sb0907.blogapp.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    // 글 추가
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    // 전체 글 조회
    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    // 글 1건 조회
    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    // 글 삭제
    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    // 글 수정
    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found: " + id));
        article.update(request.getTitle(), request.getContent());
        return article;
    }

}
