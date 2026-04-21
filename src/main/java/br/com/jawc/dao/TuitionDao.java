/**
 * @author jawc
 */
package br.com.jawc.dao;

import br.com.jawc.dao.interfaces.ITuitionDao;
import br.com.jawc.domain.Tuition;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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
}
