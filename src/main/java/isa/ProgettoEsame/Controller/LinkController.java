package isa.ProgettoEsame.Controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import isa.ProgettoEsame.model.*;
import isa.ProgettoEsame.service.*;

@Controller
public class LinkController {

    @Autowired
    private LinkService linkService;

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

}
