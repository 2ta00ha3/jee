package dao;

import java.util.List;
import domain.Etudiant;

public interface IEtudiantDao {
    void add(Etudiant e);
    void delete(String code);
    List<Etudiant> findAll();
    void update(Etudiant e);
    List<Etudiant> findByVille(String v);
    Etudiant findByCode(String c);
}
