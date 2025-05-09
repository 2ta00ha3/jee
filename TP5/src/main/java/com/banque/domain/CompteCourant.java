package com.banque.domain;

import javax.persistence.*;

@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte {
    @Column(name="DECOUVERT")
    private Double decouvert;

    public CompteCourant() {}

    public Double getDecouvert() { return decouvert; }
    public void setDecouvert(Double decouvert) { this.decouvert = decouvert; }
}
