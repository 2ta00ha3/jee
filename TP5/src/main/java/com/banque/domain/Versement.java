package com.banque.domain;

import java.util.Date;
import javax.persistence.*;

@Entity
@DiscriminatorValue("V")
public class Versement extends Operation {

    public Versement() {}

    public Versement(
        Date dateOperation,
        Double montant,
        Compte compte,
        Employe employe
    ) {
        super(dateOperation, montant, compte, employe);
    }
}
