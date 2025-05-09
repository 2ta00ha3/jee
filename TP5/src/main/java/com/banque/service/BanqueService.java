package com.banque.service;

import com.banque.dao.IBanqueDAO;
import com.banque.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BanqueService implements IBanqueService {
    @Autowired
    private IBanqueDAO dao;

    @Override
    public void addClient(Client client) {
        dao.addClient(client);
    }

    @Override
    public void addEmploye(Employe employe, Long codeSup) {
        dao.addEmploye(employe, codeSup);
    }

    @Override
    public void addGroupe(Groupe groupe) {
        dao.addGroupe(groupe);
    }

    @Override
    public void addEmployeToGroupe(Long codeEmp, Long codeGr) {
        dao.addEmployeToGroupe(codeEmp, codeGr);
    }

    @Override
    public void addCompte(Compte compte, Long codeClient, Long codeEmploye) {
        dao.addCompte(compte, codeClient, codeEmploye);
    }

    @Override
    public Compte consulterCompte(String codeCompte) {
        return dao.consulterCompte(codeCompte);
    }

    @Override
    public void versement(String codeCompte, double montant, Long codeEmploye) {
        Compte compte = dao.consulterCompte(codeCompte);
        compte.setSolde(compte.getSolde() + montant);
        Versement versement = new Versement(new Date(), montant, compte, null);
        dao.addOperation(versement, codeCompte, codeEmploye);
    }

    @Override
    public void retrait(String codeCompte, double montant, Long codeEmploye) {
        Compte compte = dao.consulterCompte(codeCompte);
        double solde = compte.getSolde();
        if (compte instanceof CompteCourant) {
            solde += ((CompteCourant) compte).getDecouvert();
        }
        if (solde < montant) {
            throw new RuntimeException("Solde insuffisant");
        }
        compte.setSolde(compte.getSolde() - montant);
        Retrait retrait = new Retrait(new Date(), montant, compte, null);
        dao.addOperation(retrait, codeCompte, codeEmploye);
    }

    @Override
    public void virement(String codeCompte1, String codeCompte2, double montant, Long codeEmploye) {
        retrait(codeCompte1, montant, codeEmploye);
        versement(codeCompte2, montant, codeEmploye);
    }

    @Override
    public List<Operation> consulterOperations(String codeCompte) {
        return dao.consulterOperations(codeCompte);
    }

    @Override
    public Client consulterClient(Long codeClient) {
        return dao.consulterClient(codeClient);
    }

    @Override
    public List<Client> consulterClients(String motCle) {
        return dao.consulterClients(motCle);
    }

    @Override
    public List<Compte> getComptesByClient(Long codeClient) {
        return dao.getComptesByClient(codeClient);
    }

    @Override
    public List<Compte> getComptesByEmploye(Long codeEmploye) {
        return dao.getComptesByEmploye(codeEmploye);
    }

    @Override
    public List<Employe> getEmployesByGroupe(Long codeGroupe) {
        return dao.getEmployesByGroupe(codeGroupe);
    }
}
