/**
 * @author jawc
 */
package br.com.jawc.dao;

import br.com.jawc.dao.interfaces.ITuitionDao;
import br.com.jawc.domain.Tuition;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class TuitionDao implements ITuitionDao {

    @Override
    public Tuition save(Tuition tuition) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExampleJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(tuition);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();


        return tuition;
    }

    @Override
    public Tuition searchByCodeCourse(String codeCourse) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExampleJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT t FROM Tuition t ");
        sb.append("INNER JOIN Course c on c = t.course ");
        sb.append("WHERE c.code = :codeCourse ");

        entityManager.getTransaction().begin();
        TypedQuery<Tuition> query =
                entityManager.createQuery(sb.toString(), Tuition.class);
        query.setParameter("codeCourse", codeCourse);
        Tuition tuition = query.getSingleResult();

        entityManager.close();
        entityManagerFactory.close();

        return tuition;
    }
}
