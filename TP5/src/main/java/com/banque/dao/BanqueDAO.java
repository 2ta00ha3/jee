package com.banque.dao;

import com.banque.domain.Client;
import com.banque.domain.Compte;
import com.banque.domain.Employe;
import com.banque.domain.Groupe;
import com.banque.domain.Operation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class BanqueDAO implements IBanqueDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void addClient(Client client) {
        em.persist(client);
    }

    @Override
    public void addEmploye(Employe employe, Long codeSup) {
        if (codeSup != null) {
            Employe sup = em.find(Employe.class, codeSup);
            employe.setSuperieur(sup);
        }
        em.persist(employe);
    }

    @Override
    public void addGroupe(Groupe groupe) {
        em.persist(groupe);
    }

    @Override
    public void addEmployeToGroupe(Long codeEmp, Long codeGr) {
        Employe employe = em.find(Employe.class, codeEmp);
        Groupe groupe = em.find(Groupe.class, codeGr);
        employe.getGroupes().add(groupe);
    }

    @Override
    public void addCompte(Compte compte, Long codeClient, Long codeEmploye) {
        Client client = em.find(Client.class, codeClient);
        Employe employe = em.find(Employe.class, codeEmploye);
        compte.setClient(client);
        compte.setEmploye(employe);
        em.persist(compte);
    }

    @Override
    public void addOperation(Operation operation, String codeCompte, Long codeEmploye) {
        Compte compte = em.find(Compte.class, codeCompte);
        Employe employe = em.find(Employe.class, codeEmploye);
        operation.setCompte(compte);
        operation.setEmploye(employe);
        em.persist(operation);
    }

    @Override
    public Compte consulterCompte(String codeCompte) {
        Compte compte = em.find(Compte.class, codeCompte);
        if (compte == null) throw new RuntimeException("Compte introuvable: " + codeCompte);
        return compte;
    }

    @Override
    public List<Operation> consulterOperations(String codeCompte) {
        Query query = em.createQuery("select o from Operation o where o.compte.codeCompte = :code");
        query.setParameter("code", codeCompte);
        return query.getResultList();
    }

    @Override
    public Client consulterClient(Long codeClient) {
        Client client = em.find(Client.class, codeClient);
        if (client == null) throw new RuntimeException("Client introuvable: " + codeClient);
        return client;
    }

    @Override
    public List<Client> consulterClients(String motCle) {
        Query query = em.createQuery("select c from Client c where c.nomClient like :mc");
        query.setParameter("mc", "%" + motCle + "%");
        return query.getResultList();
    }

    @Override
    public List<Compte> getComptesByClient(Long codeClient) {
        Query query = em.createQuery("select c from Compte c where c.client.codeClient = :code");
        query.setParameter("code", codeClient);
        return query.getResultList();
    }

    @Override
    public List<Compte> getComptesByEmploye(Long codeEmploye) {
        Query query = em.createQuery("select c from Compte c where c.employe.codeEmploye = :code");
        query.setParameter("code", codeEmploye);
        return query.getResultList();
    }

    @Override
    public List<Employe> getEmployesByGroupe(Long codeGroupe) {
        Query query = em.createQuery("select e from Employe e join e.groupes g where g.codeGroupe = :code");
        query.setParameter("code", codeGroupe);
        return query.getResultList();
    }
}
