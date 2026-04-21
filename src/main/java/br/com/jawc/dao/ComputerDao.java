/**
 * @author jawc
 */
package br.com.jawc.dao;

import br.com.jawc.dao.interfaces.IComputerDao;
import br.com.jawc.domain.Computer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ComputerDao implements IComputerDao {
    @Override
    public Computer save(Computer computer) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExampleJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(computer);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();


        return computer;
    }
}
