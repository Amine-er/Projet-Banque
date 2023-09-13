package com.estc.projetbanque.web;

import com.estc.projetbanque.service.IBanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BanqueController {
    @Autowired
    IBanqueService iBanqueService;
    @RequestMapping("/operations")
    public String index(){
        return "comptes";
    }

}
