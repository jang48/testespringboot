package com.korea.springtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class testController {
  @Autowired
  Articlerepository articlerepository;
  @GetMapping("/test")
  @ResponseBody
  public String test(){
    return "test";
  }

  @GetMapping("/")
  public String list(Model model){
    List<Article> articles = this.articlerepository.findAll();
    model.addAttribute("articles", articles);
    model.addAttribute("articleList",articles.get(0));
    return "test";
  }
  @GetMapping("/add")
  public String add(){
    Article article = new Article();
    article.setTitle("new title");
    article.setContent("");
    article.setDateTime(LocalDateTime.now());
    this.articlerepository.save(article);
    return "redirect:/";
  }

  @GetMapping("/detail/{id}")
  public String detail(Model model,@PathVariable int id  ){
    Article article = this.articlerepository.findById(id).get();
    model.addAttribute("articleList",article);
    model.addAttribute("articles",this.articlerepository.findAll());
    return "test";
  }

  @PostMapping("/update")
  private String update(Integer id, String title, String content){
    Article article = this.articlerepository.findById(id).get();
    article.setTitle(title);
    article.setContent(content);
    article.setDateTime(LocalDateTime.now());
    this.articlerepository.save(article);
    return "redirect:/detail/" + id ;
  }
}
