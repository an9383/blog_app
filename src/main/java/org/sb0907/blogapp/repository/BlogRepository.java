package org.sb0907.blogapp.repository;

import org.sb0907.blogapp.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {

}
