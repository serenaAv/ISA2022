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

@Controller
public class BusController {

    @Autowired
    private BusService busService;

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
}
