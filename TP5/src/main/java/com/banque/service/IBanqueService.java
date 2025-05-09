package com.banque.service;

import com.banque.domain.Client;
import com.banque.domain.Compte;
import com.banque.domain.Employe;
import com.banque.domain.Groupe;
import com.banque.domain.Operation;
import java.util.List;

public interface IBanqueService {
    void addClient(Client client);
    void addEmploye(Employe employe, Long codeSup);
    void addGroupe(Groupe groupe);
    void addEmployeToGroupe(Long codeEmp, Long codeGr);
    void addCompte(Compte compte, Long codeClient, Long codeEmploye);
    Compte consulterCompte(String codeCompte);
    void versement(String codeCompte, double montant, Long codeEmploye);
    void retrait(String codeCompte, double montant, Long codeEmploye);
    void virement(String codeCompte1, String codeCompte2, double montant, Long codeEmploye);
    List<Operation> consulterOperations(String codeCompte);
    Client consulterClient(Long codeClient);
    List<Client> consulterClients(String motCle);
    List<Compte> getComptesByClient(Long codeClient);
    List<Compte> getComptesByEmploye(Long codeEmploye);
    List<Employe> getEmployesByGroupe(Long codeGroupe);
}
