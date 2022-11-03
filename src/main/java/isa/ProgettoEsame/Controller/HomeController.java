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

    /*
     * LOGIN
     */

    @RequestMapping("/login.html")
    public String login() {
      return "login.html";
    }

    @RequestMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login.html";
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
    public String saveLink(@ModelAttribute("link") Link link) {
        linkService.saveLink(link);
        return "redirect:/link";
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
    public String saveBus(@ModelAttribute("bus") Bus bus) {
        busService.saveBus(bus);
        return "redirect:/bus";
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

    @RequestMapping("/logout.html")
    public String logout() {
      return "login.html";
    } 

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
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/user";
    }

    @PostMapping("/saveUser_reg")
    public String saveUser_reg(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/login.html";
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
        mav.addObject("travel", new Travel());
        return mav;
    }

    @PostMapping("/saveTravel")
    public String saveTravel(@ModelAttribute("travel") Travel travel) {
        travelService.saveTravel(travel);
        return "redirect:/travel";
    }

    @GetMapping("/travel/detail/{id}")
    public String showFormForDetail_travel(@PathVariable(value = "id") int id, Model model) {

        Travel travel = travelService.getTravelById(id);

        model.addAttribute("travel", travel);
        return "travel_detail";
    }
    
}
