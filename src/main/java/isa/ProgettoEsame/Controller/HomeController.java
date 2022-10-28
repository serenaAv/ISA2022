package isa.ProgettoEsame.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
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

    @RequestMapping(value="/link/update/{id}",method=RequestMethod.GET)
    public ModelAndView link_edit(@PathVariable(value = "id") int id){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("link_edit");
        mav.addObject("Listalink", linkService.getAllLinks());
        return mav;
    }

    @GetMapping("/link/delete/{id}")
    public String deleteEmployee(@PathVariable(value = "id") int id) {
        this.linkService.deleteLinkById(id);
        return "redirect:/link";
    }
}
