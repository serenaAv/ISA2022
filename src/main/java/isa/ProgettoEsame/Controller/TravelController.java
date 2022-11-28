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

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDate;

@Controller
public class TravelController {
 
    @Autowired
    private TravelService travelService;

    @Autowired
    private LinkService linkService;
    
    @Autowired
    private BusService busService;

    @RequestMapping(value="/travel",method=RequestMethod.GET)
    public ModelAndView travel(){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("travel");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("admin"))) {
            mav.addObject("Listatravel", travelService.getAllTravels());
        }
        else
        {
            mav.addObject("Listatravel",travelService.getAllTravelByDateGreaterThanEqual(LocalDate.now()));
        }
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
}
