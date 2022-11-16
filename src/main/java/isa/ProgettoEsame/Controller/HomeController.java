package isa.ProgettoEsame.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.stereotype.Controller;
import isa.ProgettoEsame.model.*;
import isa.ProgettoEsame.service.*;

import javax.validation.Valid;
import org.springframework.validation.Errors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;

@Controller
public class HomeController {

  @Autowired
  private LinkService linkService;
  
  @Autowired
  private BusService busService;

  @Autowired
  private UserService userService;

  @Autowired
  private TravelService travelService;

  @Autowired
  private BookService bookService;

    /*
     * LOGIN
     */

    @RequestMapping("/login.html")
    public String login() {
      return "login.html";
    }

    @RequestMapping("/logout.html")
    public String logout() {
      return "login.html";
    }


    @RequestMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login.html";
    }

    @RequestMapping("/index.html")
    public String index() {
      return "index.html";
        }
    /*
    * LINK
    */
    @RequestMapping("/link.html")
    public String link(Model model) {
        model.addAttribute("listLink", true);
        return "link.html";
    }

    @RequestMapping(value="/link",method=RequestMethod.GET)
    public ModelAndView link(){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("link");
        mav.addObject("Listalink", linkService.getAllLinks());
        return mav;
    }

    @GetMapping("/link/delete/{id}")
    public String deleteLink(@PathVariable(value = "id") int id) {

        this.linkService.deleteLinkById(id);
        return "redirect:/link";
    }

    @RequestMapping(value="/link/add",method=RequestMethod.GET)
    public ModelAndView link_add(){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("link_add");
        mav.addObject("link", new Link());
        return mav;
    }

    @PostMapping("/saveLink")
    public String saveLink(@Valid @ModelAttribute("link") Link link, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "link_add"; 
        } else {
        linkService.saveLink(link);
        return "redirect:/link";
        }
    }

    @GetMapping("/link/edit/{id}")
    public String showFormForUpdate_link(@PathVariable(value = "id") int id, Model model) {

        Link link = linkService.getLinkById(id);

        model.addAttribute("link", link);
        return "link_edit";
    }

    /*
     * BUS
     */

    @RequestMapping(value="/bus",method=RequestMethod.GET)
    public ModelAndView bus(){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("bus");
        mav.addObject("Listabus", busService.getAllBus());
        return mav;
    }


    @GetMapping("/bus/delete/{id}")
    public String deleteBus(@PathVariable(value = "id") int id) {

        this.busService.deleteBusById(id);
        return "redirect:/bus";
    }

    @RequestMapping(value="/bus/add",method=RequestMethod.GET)
    public ModelAndView bus_add(){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("bus_add");
        mav.addObject("bus", new Bus());
        return mav;
    }

    @PostMapping("/saveBus")
    public String saveBus(@Valid @ModelAttribute("bus") Bus bus, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "bus_add"; 
        } else {
        busService.saveBus(bus);
        return "redirect:/bus";
        }
    }

    @GetMapping("/bus/edit/{id}")
    public String showFormForUpdate_bus(@PathVariable(value = "id") int id, Model model) {

        Bus bus = busService.getBusById(id);

        model.addAttribute("bus", bus);
        return "bus_edit";
    }

    @GetMapping("/bus/detail/{id}")
    public String showFormForDetail_bus(@PathVariable(value = "id") int id, Model model) {

        Bus bus = busService.getBusById(id);

        model.addAttribute("bus", bus);
        return "bus_detail";
    }
    
    /*
     * USER
     */

    @RequestMapping(value="/registration",method=RequestMethod.GET)
    public ModelAndView user_reg(){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("user_reg");
        mav.addObject("user", new User());
        return mav;
    }


    @RequestMapping(value="/user",method=RequestMethod.GET)
    public ModelAndView user(){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("user");
        mav.addObject("Listauser", userService.getAllUser());
        return mav;
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable(value = "id") int id) {

        this.userService.deleteUserById(id);
        return "redirect:/user";
    }

    @RequestMapping(value="/user/add",method=RequestMethod.GET)
    public ModelAndView user_add(){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("user_add");
        mav.addObject("user", new User());
        return mav;
    }

    @PostMapping("/saveUser")
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult  bindingResult) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPw = encoder.encode(user.getPassword());
        user.setPassword(encodedPw);
        if (bindingResult.hasErrors()){
            return "user_add"; 
        }
        else{
            userService.saveUser(user);
            return "redirect:/user";
        }
    }

    @PostMapping("/saveUser_reg")
    public String saveUser_reg(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "user_reg"; 
        } else {
            userService.saveUser(user);
        return "redirect:/login.html";
        }
    }

    @GetMapping("/user/edit/{id}")
    public String showFormForUpdate_user(@PathVariable(value = "id") int id, Model model) {

        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user_edit";
    }

    @GetMapping("/user/detail/{id}")
    public String showFormForDetail_user(@PathVariable(value = "id") int id, Model model) {

        User user = userService.getUserById(id);

        model.addAttribute("user", user);
        return "user_detail";
    }

    @GetMapping("/myProfile")
    public String UserProfile(@AuthenticationPrincipal MyUserDetails user, Model model) {
        model.addAttribute("user", user);
        return "myProfile";
    }
  
    /*
     * TRAVEL
     */

    @RequestMapping(value="/travel",method=RequestMethod.GET)
    public ModelAndView travel(){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("travel");
        mav.addObject("Listatravel", travelService.getAllTravels());
        return mav;
    }

    @RequestMapping(value="/travel/add",method=RequestMethod.GET)
    public ModelAndView travel_add(){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("travel_add");
        mav.addObject("Listabus",busService.getAllBus());
        mav.addObject("Listalink",linkService.getAllLinks());
        mav.addObject("travel", new Travel());
        mav.addObject("date", LocalDate.now());
        return mav;
    }

    @PostMapping("/saveTravel")
    public String saveTravel(@Valid @ModelAttribute("travel") Travel travel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "travel_add"; 
        } else {
        travelService.saveTravel(travel);
        return "redirect:/travel";
        }
    }

    @GetMapping("/travel/detail/{id}")
    public String showFormForDetail_travel(@PathVariable(value = "id") int id, Model model) {

        Travel travel = travelService.getTravelById(id);

        model.addAttribute("travel", travel);
        return "travel_detail";
    }

    @GetMapping("/travel/delete/{id}")
    public String deleteTravel(@PathVariable(value = "id") int id) {

        this.travelService.deleteTravelById(id);
        return "redirect:/travel";
    }

    /*
     * BOOK
     */

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
    public ModelAndView myBook(){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("myBook");
        mav.addObject("Listatravel",travelService.getAllTravels());
        mav.addObject("Listabook", bookService.getAllBooks());
        mav.addObject("Listauser", userService.getAllUser());
        return mav;
    }

    @RequestMapping(value="/book/add",method=RequestMethod.GET)
    public ModelAndView book_add(@AuthenticationPrincipal MyUserDetails meUser){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("book_add");
        mav.addObject("book", new Book());
        mav.addObject("Listatravel",travelService.getAllTravels());
        mav.addObject("Listauser", userService.getAllUser());
        mav.addObject("meUser", meUser);
        return mav;
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.saveBook(book);
        return "redirect:/book";
    }

    @PostMapping("/saveMyBook")
    public String saveMyBook(@ModelAttribute("book") Book book) {
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
        return "book_edit";
    }

    
    
}
