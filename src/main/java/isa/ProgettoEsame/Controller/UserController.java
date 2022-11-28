package isa.ProgettoEsame.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;
import isa.ProgettoEsame.model.*;
import isa.ProgettoEsame.repository.RoleRepository;
import isa.ProgettoEsame.service.*;
import net.bytebuddy.utility.RandomString;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

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
        if (bindingResult.hasErrors()){
            return "user_add"; 
        }
        else{
            userService.saveUser(user);
            return "redirect:/user";
        }
    }

    @PostMapping("/saveUserWithoutPw_P")
    public String saveWithoutPw_profile(@ModelAttribute("user") User user) {
        User storedUser = userService.getUserById(user.getId());
        user.setPassword(storedUser.getPassword());
        userService.saveUserWithoutPw(user);
        return "redirect:/login.html";
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

    @PostMapping("/saveUserWithoutPw")
    public String saveUserEdit(@ModelAttribute("user") User user) {
        User DbUser = userService.getUserById(user.getId());
        user.setPassword(DbUser.getPassword());
        userService.saveUserWithoutPw(user);
        return "redirect:/user";
    }

    @GetMapping("/user/detail/{id}")
    public String showFormForDetail_user(@PathVariable(value = "id") int id, Model model) {

        User user = userService.getUserById(id);

        model.addAttribute("user", user);
        return "user_detail";
    }

    @GetMapping("/myProfile")
    public String UserProfile(@AuthenticationPrincipal MyUserDetails loggedUser, Model model) {
        User user = userService.getUserByUsername(loggedUser.getUsername());
        model.addAttribute("user", user);
        return "myProfile";
    }


    @RequestMapping(value="/changePw",method=RequestMethod.GET)
    public ModelAndView ChangePassword(@AuthenticationPrincipal MyUserDetails user){

        ModelAndView mav=new ModelAndView();
        mav.setViewName("ResetPwForm");
        String email = user.getEmail();
        //generate token di 45 (vedi max dim nella tabella di mysql)
        String token = RandomString.make(45);
        try
        {
            userService.updateResetPwToken(token, email);
        }
        catch (EmailNotFoundException exception)
        {
            mav.addObject("error", exception.getMessage());
        }
        mav.addObject("user", user);
        mav.addObject("token", token);
        return mav;
    }
    
}
