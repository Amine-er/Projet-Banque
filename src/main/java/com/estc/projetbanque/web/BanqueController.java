package com.estc.projetbanque.web;

import com.estc.projetbanque.entities.Compte;
import com.estc.projetbanque.entities.Operation;
import com.estc.projetbanque.service.IBanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BanqueController {
    @Autowired
    IBanqueService banqueService;
    @RequestMapping("/operations")
    public String index(){
        return "comptes";
    }

    @RequestMapping("/consulterCompte")
    public String consulter(Model model, String codeCompte){
        try {
            Compte cp = banqueService.consulterCompte(codeCompte);
            Page<Operation> operationPage = banqueService.listOperation(codeCompte,0,4);
            model.addAttribute("compte",cp);
            model.addAttribute("listOperations",operationPage.getContent());
            model.addAttribute("typeCompte",cp.getClass().getSimpleName());
            model.addAttribute("codeCompte",codeCompte);
        }catch (Exception e){
            model.addAttribute("exception",e);
        }
        return "comptes";
    }
}
