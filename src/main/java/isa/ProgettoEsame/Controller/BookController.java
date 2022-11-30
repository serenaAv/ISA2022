package isa.ProgettoEsame.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import isa.ProgettoEsame.model.*;
import isa.ProgettoEsame.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import java.time.LocalDate;

@Controller
public class BookController {
    
  @Autowired
  private BookService bookService;

  @Autowired
  private UserService userService;

  @Autowired
  private TravelService travelService;

    @RequestMapping(value="/book",method=RequestMethod.GET)
    public ModelAndView book(){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("book");
        mav.addObject("Listatravel",travelService.getAllTravels());
        mav.addObject("Listabook", bookService.getAllBooks());
        mav.addObject("Listauser", userService.getAllUser());
        return mav;
    }

    @RequestMapping(value="/myBook",method=RequestMethod.GET)
    public ModelAndView myBook(@AuthenticationPrincipal MyUserDetails meUser){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("myBook");
        mav.addObject("Listatravel",travelService.getAllTravels());
        mav.addObject("Listabook", bookService.getAllBooksByUserId(meUser.getId()));
        mav.addObject("Listauser", userService.getAllUser());
        return mav;
    }

    @RequestMapping(value="/book/add",method=RequestMethod.GET)
    public ModelAndView book_add(@AuthenticationPrincipal MyUserDetails meUser){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("book_add");
        mav.addObject("book", new Book());
        mav.addObject("Listatravel",travelService.getAllTravelByDateGreaterThanEqual(LocalDate.now()));
        mav.addObject("Listauser", userService.getAllUser());
        mav.addObject("meUser", meUser);
        mav.addObject("date", LocalDate.now());
        return mav;
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book) {
        book.setDate_book(LocalDate.now());
        bookService.saveBook(book);
        return "redirect:/book";
    }

    @PostMapping("/saveMyBook")
    public String saveMyBook(@ModelAttribute("book") Book book, @AuthenticationPrincipal MyUserDetails meUser) {
        book.setDate_book(LocalDate.now());
        bookService.saveBook(book);
        return "redirect:/myBook";
    }

    @GetMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable(value = "id") int id) {

        this.bookService.deleteBookById(id);
        return "redirect:/book";
    }

    @GetMapping("/book/edit/{id}")
    public String showFormForUpdate_book(@PathVariable(value = "id") int id, Model model) {

        Book book = bookService.getBookById(id);

        model.addAttribute("book", book);
        model.addAttribute("Listatravel",travelService.getAllTravels());
        return "book_edit";
    }
}
