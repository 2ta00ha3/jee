package com.banque.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

@Entity
@Table(name="CLIENTS")
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="CODE_CLIENT")
    private Long codeClient;

    @Column(name="NOM_CLIENT")
    private String nomClient;

    @Column(name="PRENOM_CLIENT")
    private String prenomClient;

    @Column(name="ADR_CLIENT")
    private String adresseClient;

    @OneToMany(mappedBy="client", fetch=FetchType.LAZY)
    private Collection<Compte> comptes;

    public Client() {}

    public Long getCodeClient() { return codeClient; }
    public void setCodeClient(Long codeClient) { this.codeClient = codeClient; }
    public String getNomClient() { return nomClient; }
    public void setNomClient(String nomClient) { this.nomClient = nomClient; }
    public String getPrenomClient() { return prenomClient; }
    public void setPrenomClient(String prenomClient) { this.prenomClient = prenomClient; }
    public String getAdresseClient() { return adresseClient; }
    public void setAdresseClient(String adresseClient) { this.adresseClient = adresseClient; }
    public Collection<Compte> getComptes() { return comptes; }
    public void setComptes(Collection<Compte> comptes) { this.comptes = comptes; }
}
