package project.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import project.bookstore.domain.BookRepository;

@Controller
public class BookController {

  private BookRepository repository;
  
  public BookController(BookRepository repository) {
    this.repository = repository;
  }

  @RequestMapping(value={"/", "/books"})
  public String books(Model model) {
    model.addAttribute("book", repository.findAll());
    return "books";
  }
}
