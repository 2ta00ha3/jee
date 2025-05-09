package com.banque.form;

import java.util.List;
import javax.validation.constraints.*;
import com.banque.domain.Compte;
import com.banque.domain.Operation;

public class BanqueForm {
    @NotEmpty
    @Size(min=3, max=10)
    private String code;

    private Compte compte;
    private String typeCompte;
    private String exception;
    private List<Operation> operations;

    @NotEmpty
    private String typeOperation;

    @NotEmpty
    @Size(min=3, max=10)
    private String code2 = "XXX";

    @DecimalMin(value="50")
    private double montant = 50;

    private String action;

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public Compte getCompte() { return compte; }
    public void setCompte(Compte compte) { this.compte = compte; }
    public String getTypeCompte() { return typeCompte; }
    public void setTypeCompte(String typeCompte) { this.typeCompte = typeCompte; }
    public String getException() { return exception; }
    public void setException(String exception) { this.exception = exception; }
    public List<Operation> getOperations() { return operations; }
    public void setOperations(List<Operation> operations) { this.operations = operations; }
    public String getTypeOperation() { return typeOperation; }
    public void setTypeOperation(String typeOperation) { this.typeOperation = typeOperation; }
    public String getCode2() { return code2; }
    public void setCode2(String code2) { this.code2 = code2; }
    public double getMontant() { return montant; }
    public void setMontant(double montant) { this.montant = montant; }
    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }
}
