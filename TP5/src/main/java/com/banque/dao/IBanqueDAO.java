package com.banque.dao;

import com.banque.domain.Client;
import com.banque.domain.Compte;
import com.banque.domain.Employe;
import com.banque.domain.Groupe;
import com.banque.domain.Operation;
import java.util.List;

public interface IBanqueDAO {
    void addClient(Client client);
    void addEmploye(Employe employe, Long codeSup);
    void addGroupe(Groupe groupe);
    void addEmployeToGroupe(Long codeEmp, Long codeGr);
    void addCompte(Compte compte, Long codeClient, Long codeEmploye);
    void addOperation(Operation operation, String codeCompte, Long codeEmploye);
    Compte consulterCompte(String codeCompte);
    List<Operation> consulterOperations(String codeCompte);
    Client consulterClient(Long codeClient);
    List<Client> consulterClients(String motCle);
    List<Compte> getComptesByClient(Long codeClient);
    List<Compte> getComptesByEmploye(Long codeEmploye);
    List<Employe> getEmployesByGroupe(Long codeGroupe);
}
