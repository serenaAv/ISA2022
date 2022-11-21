package isa.ProgettoEsame.Controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import isa.ProgettoEsame.utility;
import isa.ProgettoEsame.model.User;
import isa.ProgettoEsame.service.EmailNotFoundException;
import isa.ProgettoEsame.service.UserService;
import net.bytebuddy.utility.RandomString;

@Controller
public class ForwardPasswordController {

    @Autowired
    private UserService userService;

    @Autowired
    private JavaMailSender mailSender;

    @RequestMapping(value="/forgot_password",method=RequestMethod.GET)
    public ModelAndView FPwForm(Model model)
    {
        ModelAndView mav=new ModelAndView();
        mav.setViewName("forgot_password_form");
        return mav; 
    }

    @PostMapping("/forgot_password")
    public String processForgotPwForm(HttpServletRequest request, Model model)
    {                                       //V nome del campo della view da cui prendo il parametro
        String email = request.getParameter("email");
        //generate token di 45 (vedi max dim nella tabella di mysql)
        String token = RandomString.make(45);

        try
        {
            userService.updateResetPwToken(token, email);
            //genero il link da cliccare per il reset pw
            String resetPwLink = utility.getSiteURL(request) + "/reset_password?token="+token;
            //invio email contenente il link
            sendEmail(email, resetPwLink);
            model.addAttribute("message", "Abbiamo appena inviato la password all'indirizzo email. Controlla la tua email.");
        }
        catch (EmailNotFoundException exception)
        {
            model.addAttribute("error", exception.getMessage());
        }
        catch (UnsupportedEncodingException | MessagingException e)
        {
            model.addAttribute("error", e.getMessage()); 
        }
        
        
        return "forgot_password_form";
    }

    @RequestMapping(value="/reset_password",method=RequestMethod.GET)
    public String showResetPwForm(@Param(value="token") String token, Model model)
    {
        //controllo che il token passato coincida con quello settato all'interno del db
        User user = userService.getUserByResetPwToken(token);
        if(user == null)
        {
            model.addAttribute("title", "Reset Password");
            model.addAttribute("message", "Utente non trovato!"); 
            return "ResetPwError";
        }
        model.addAttribute("token", token);
        return "ResetPwForm";
    }

    @PostMapping("/reset_password")
    public String processResetPw(HttpServletRequest request, Model model)
    {
        String token = request.getParameter("token");
        System.out.println("Il token passato è:"+token);
        String password = request.getParameter("password");
        System.out.println("La password passata è:"+password);
        User u = userService.getUserByResetPwToken(token);
        //System.out.println("Lo user considerato è"+u.getFirstname());
        if(u == null)
        {
            System.out.println("Lo user è null");
            model.addAttribute("title", "Reset Password");
            model.addAttribute("message", "Utente non trovato!"); 
            return "ResetPwError";
        }
        else
        {
            userService.updatePw(u, password);
            model.addAttribute("message", "La tua password è stata cambiata correttamente!");
            return "ResetPwError";
        }
    }

    private void sendEmail(String email, String resetPwLink) throws UnsupportedEncodingException, MessagingException
    {
         MimeMessage message = mailSender.createMimeMessage();
         MimeMessageHelper helper = new MimeMessageHelper(message);
         //setto email mittente
         helper.setFrom("contact@prjectISA.com", "Project ISA Support");  
         //setto email ricevente
         helper.setTo(email);
         String subject="Link per il reset della password";
         String content ="<p>Ciao, </p>" + "<p>Ecco il link per il reset della password:</p>" + "<p><a href=\"" + resetPwLink + "\">Cambia la password</a></p>";
         helper.setSubject(subject);
         helper.setText(content, true);

         mailSender.send(message);
    
    }
     
}
