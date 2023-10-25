package com.korea.springtest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Articlerepository extends JpaRepository<Article, Integer> {
}
