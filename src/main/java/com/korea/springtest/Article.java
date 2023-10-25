package com.korea.springtest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Article {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer ID;

  public String title;
  public String content;
  public LocalDateTime DateTime;
}
