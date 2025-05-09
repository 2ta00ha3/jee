package com.banque.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="COMPTES")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_COMPTE", discriminatorType=DiscriminatorType.STRING, length=4)
public abstract class Compte implements Serializable {
    @Id
    @Column(name="CODE_COMPTE")
    private String codeCompte;

    @Column(name="DATE_CREATION")
    @Temporal(TemporalType.DATE)
    private Date dateCreation;

    @Column(name="SOLDE")
    private Double solde;

    @ManyToOne
    @JoinColumn(name="CODE_CLIENT")
    private Client client;

    @ManyToOne
    @JoinColumn(name="CODE_EMPLOYE")
    private Employe employe;

    @OneToMany(mappedBy="compte", fetch=FetchType.LAZY)
    private Collection<Operation> operations;

    public Compte() {}

    public String getCodeCompte() { return codeCompte; }
    public void setCodeCompte(String codeCompte) { this.codeCompte = codeCompte; }
    public Date getDateCreation() { return dateCreation; }
    public void setDateCreation(Date dateCreation) { this.dateCreation = dateCreation; }
    public Double getSolde() { return solde; }
    public void setSolde(Double solde) { this.solde = solde; }
    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
    public Employe getEmploye() { return employe; }
    public void setEmploye(Employe employe) { this.employe = employe; }
    public Collection<Operation> getOperations() { return operations; }
    public void setOperations(Collection<Operation> operations) { this.operations = operations; }
}
