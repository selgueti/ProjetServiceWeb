package fr.uge.projet.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HttpUserController {

    @GetMapping("/login")
    public String getLoginForm(){

        //on recupere les les attributs passer dans le form <----- C
        // mais je pense que on aura pas besoin en les renvoyant au front mais il faut les envoyer dans un objet HttpUser

        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute(name="loginForm") Login login, BindingResult result, Model m){


        String uname = login.getPseudo();
        String pass = login.getPassword();


        if(uname.equals("Admin") && pass.equals("Admin")) {

            m.addAttribute("uname", uname);
            m.addAttribute("pass", pass);
            return "acceuil";
        }


        return "login";

    }

    @GetMapping("/list-bike")
    public String listBike(){
        return "list-bike";
    }



    }
