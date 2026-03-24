package project.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.bookstore.domain.Category;
import project.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

  private final CategoryRepository categoryRepository;

  public CategoryController(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @RequestMapping(value={"/", "/categorylist"}, method=RequestMethod.GET)
  public String categories(Model model) {
    model.addAttribute("categories", categoryRepository.findAll());
    return "categorylist";
  }

  @RequestMapping(value="/addcategory")
  public String addCategory(Model model) {
    model.addAttribute("category", new Category());
    return "addcategory";
  } 

  @RequestMapping(value="/savecategory", method=RequestMethod.POST)
  public String save(Category category) {
    categoryRepository.save(category);
    return "redirect:/categorylist";
  }
}