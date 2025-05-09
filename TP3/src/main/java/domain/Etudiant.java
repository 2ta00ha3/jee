package domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Etudiant {
    @Id
    private String code;
    private String nom;
    private String ville;
    private int age;

    // Default constructor for JPA
    public Etudiant() {}

    public Etudiant(String code, String nom, String ville, int age) {
        this.code = code;
        this.nom = nom;
        this.ville = ville;
        this.age = age;
    }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return "Etudiant{code='" + code + "', nom='" + nom + "', ville='" + ville + "', age=" + age + "}";
    }
}
