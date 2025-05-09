package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import domain.Etudiant;

public class EtudiantDaoJPA implements IEtudiantDao {
    private EntityManager em = ConnectionFactoryJPA.getEntityManager();

    @Override
    public void add(Etudiant e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    @Override
    public void delete(String code) {
        em.getTransaction().begin();
        Etudiant e = findByCode(code);
        if (e != null) {
            em.remove(e);
        }
        em.getTransaction().commit();
    }

    @Override
    public List<Etudiant> findAll() {
        Query q = em.createQuery("SELECT e FROM Etudiant e");
        return q.getResultList();
    }

    @Override
    public void update(Etudiant e) {
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
    }

    @Override
    public List<Etudiant> findByVille(String v) {
        Query query = em.createQuery("SELECT e FROM Etudiant e WHERE e.ville = :ville");
        query.setParameter("ville", v);
        return query.getResultList();
    }

    @Override
    public Etudiant findByCode(String c) {
        return em.find(Etudiant.class, c);
    }
}
