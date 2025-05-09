package com.banque.controller;

import com.banque.domain.Compte;
import com.banque.domain.CompteCourant;
import com.banque.domain.CompteEpargne;
import com.banque.form.BanqueForm;
import com.banque.service.IBanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;

@Controller
public class BanqueController {
    @Autowired
    private IBanqueService service;

    @RequestMapping(value = "/banque", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("banqueForm", new BanqueForm());
        return "banque";
    }

    @RequestMapping(value = "/saveOperation", method = RequestMethod.POST)
    public String saveOperation(@Valid @ModelAttribute("banqueForm") BanqueForm banqueForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "banque";
        }
        try {
            if (banqueForm.getAction() != null && banqueForm.getAction().equals("save")) {
                String typeOp = banqueForm.getTypeOperation();
                String codeCompte = banqueForm.getCode();
                double montant = banqueForm.getMontant();
                Long codeEmploye = 1L; // Hardcoded for simplicity; replace with actual employee logic
                if (typeOp.equals("VER")) {
                    service.versement(codeCompte, montant, codeEmploye);
                } else if (typeOp.equals("RET")) {
                    service.retrait(codeCompte, montant, codeEmploye);
                } else if (typeOp.equals("VIR")) {
                    String codeCompte2 = banqueForm.getCode2();
                    service.virement(codeCompte, codeCompte2, montant, codeEmploye);
                }
            }
            Compte compte = service.consulterCompte(banqueForm.getCode());
            banqueForm.setCompte(compte);
            banqueForm.setTypeCompte(compte instanceof CompteCourant ? "CompteCourant" : "CompteEpargne");
            banqueForm.setOperations(service.consulterOperations(banqueForm.getCode()));
            banqueForm.setException(null);
        } catch (Exception e) {
            banqueForm.setException(e.getMessage());
        }
        return "banque";
    }
}
