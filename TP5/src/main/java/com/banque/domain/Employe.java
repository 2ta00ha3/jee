package com.banque.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

@Entity
@Table(name="EMPLOYES")
public class Employe implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="CODE_EMPLOYE")
    private Long codeEmploye;

    @Column(name="NOM_EMPLOYE")
    private String nomEmploye;

    @ManyToOne
    @JoinColumn(name="CODE_SUP")
    private Employe superieur;

    @ManyToMany
    @JoinTable(name="EMPLOYE_GROUPE",
        joinColumns=@JoinColumn(name="CODE_EMPLOYE"),
        inverseJoinColumns=@JoinColumn(name="CODE_GROUPE"))
    private Collection<Groupe> groupes;

    public Employe() {}

    public Long getCodeEmploye() { return codeEmploye; }
    public void setCodeEmploye(Long codeEmploye) { this.codeEmploye = codeEmploye; }
    public String getNomEmploye() { return nomEmploye; }
    public void setNomEmploye(String nomEmploye) { this.nomEmploye = nomEmploye; }
    public Employe getSuperieur() { return superieur; }
    public void setSuperieur(Employe superieur) { this.superieur = superieur; }
    public Collection<Groupe> getGroupes() { return groupes; }
    public void setGroupes(Collection<Groupe> groupes) { this.groupes = groupes; }
}
