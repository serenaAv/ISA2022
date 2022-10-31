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
import org.springframework.stereotype.Controller;
import isa.ProgettoEsame.model.*;
import isa.ProgettoEsame.service.*;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class HomeController {

  @Autowired
  private LinkService linkService;
  
  @Autowired
  private BusService busService;

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
    

}
