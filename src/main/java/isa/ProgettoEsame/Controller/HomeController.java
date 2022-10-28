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
import isa.ProgettoEsame.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class HomeController {

  @Autowired
  private LinkService linkService;

    @RequestMapping("/login.html")
    public String login() {
      return "login.html";
    }

    @RequestMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login.html";
    }

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
/*
@RequestMapping(value="/editlink",method= RequestMethod.POST)
            public ModelAndView do_update(Link n, BindingResult bindingResult){
            linkService.saveLink(n);
            return new ModelAndView("redirect:/link");
        } 
    @RequestMapping(value="/link/edit/{id}",method=RequestMethod.GET)
            public ModelAndView updatesLink(@PathVariable Integer id){
            ModelAndView mav=new ModelAndView();
            mav.addObject("link", linkService.getLinkById(id));
            mav.setViewName("link_edit");
            return mav;
        }
        */

    @GetMapping("/link/edit/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {

        Link link = linkService.getLinkById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("link", link);
        return "link_edit";
    }
    

}
