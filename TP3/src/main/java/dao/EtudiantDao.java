package dao;

import domain.Etudiant;
import java.util.*;

public class EtudiantDao implements IEtudiantDao {

    private static Map<String, Etudiant> etudiants = new HashMap<>();

    static {
        etudiants.put("A1", new Etudiant("1", "Taha", "Gara", 20));
        etudiants.put("A2", new Etudiant("2", "Ahmed", "Casa", 21));
        etudiants.put("B1", new Etudiant("3", "Mohsin", "Casa", 20));
        etudiants.put("B2", new Etudiant("4", "Ramzi", "Agadir", 20));
        etudiants.put("C1", new Etudiant("5", "Malik", "Daroa", 20));
    }

    @Override
    public void add(Etudiant e) {
        etudiants.put(e.getCode(), e);
    }

    @Override
    public void delete(String code) {
        etudiants.remove(code);
    }

    @Override
    public List<Etudiant> findAll() {
        return new ArrayList<>(etudiants.values());
    }

    @Override
    public void update(Etudiant e) {
        etudiants.put(e.getCode(), e);
    }

    @Override
    public List<Etudiant> findByVille(String v) {
        List<Etudiant> result = new ArrayList<>();
        for (Etudiant e : etudiants.values()) {
            if (e.getVille().equals(v)) {
                result.add(e);
            }
        }
        return result;
    }

    @Override
    public Etudiant findByCode(String c) {
        return etudiants.get(c);
    }
}
