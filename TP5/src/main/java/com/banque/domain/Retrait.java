package com.banque.domain;

import java.util.Date;
import javax.persistence.*;

@Entity
@DiscriminatorValue("R")
public class Retrait extends Operation {

    public Retrait() {}

    public Retrait(
        Date dateOperation,
        Double montant,
        Compte compte,
        Employe employe
    ) {
        super(dateOperation, montant, compte, employe);
    }
}
