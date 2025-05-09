package com.banque.domain;

import javax.persistence.*;

@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {
    @Column(name="TAUX_INTERET")
    private Double tauxInteret;

    public CompteEpargne() {}

    public Double getTauxInteret() { return tauxInteret; }
    public void setTauxInteret(Double tauxInteret) { this.tauxInteret = tauxInteret; }
}
