package fr.uge.projet.rest;

import fr.uge.projet.bike.IBike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class BikeControlleur {

    public BikeControlleur(BikeManagerHandler managerHandler) {
        this.managerHandler = managerHandler;
    }

    private final BikeManagerHandler managerHandler;


//    @CrossOrigin
    @GetMapping("/bikes")
    public String getAll(Model model) {
        var listBikes =  managerHandler.getAll();

        //ajouter la liste des bikes dans model attribute et le recup dans l'Html 'list-bike'

        model.addAttribute(listBikes);
        return "list-bike";
    }






}
