package project.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.bookstore.domain.Book;
import project.bookstore.domain.BookRepository;
import project.bookstore.domain.CategoryRepository;

@Controller
public class BookController {

  private final CategoryRepository categoryRepository;
  private final BookRepository repository;
  
  public BookController(BookRepository repository, CategoryRepository categoryRepository) {
    this.repository = repository;
    this.categoryRepository = categoryRepository;
  }

  @RequestMapping(value={"/", "/booklist"}, method=RequestMethod.GET)
  public String books(Model model) {
    model.addAttribute("books", repository.findAll());
    return "booklist";
  }

  @RequestMapping(value="/add")
  public String addBook(Model model) {
    model.addAttribute("book", new Book());
    model.addAttribute("categories", categoryRepository.findAll());
    return "addbook";
  }

  @RequestMapping(value="/save", method=RequestMethod.POST) 
  public String save(Book book) {
    repository.save(book);
    return "redirect:/booklist";
  }

  @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
  public String deleteBook(@PathVariable("id") Long bookId) {
    repository.deleteById(bookId);
    return "redirect:/booklist";
  }

  @RequestMapping(value = "/edit/{id}")
  public String editBook(@PathVariable("id") Long bookId, Model model) {
    Book book = repository.findById(bookId).orElse(null);
    model.addAttribute("book", book);
    model.addAttribute("categories", categoryRepository.findAll());
    return "editbook";
  }
}