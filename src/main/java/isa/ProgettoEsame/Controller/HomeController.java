package isa.ProgettoEsame.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

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

}
