package project.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.bookstore.domain.BookRepository;

@Controller
public class BookController {

  private final BookRepository repository;
  
  public BookController(BookRepository repository) {
    this.repository = repository;
  }

  @RequestMapping(value={"/", "/booklist"}, method=RequestMethod.GET)
  public String books(Model model) {
    model.addAttribute("books", repository.findAll());
    return "booklist";
  }
}
