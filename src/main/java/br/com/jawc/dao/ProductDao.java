/**
 * @author jawc
 */
package br.com.jawc.dao;

import br.com.jawc.dao.interfaces.IProductDao;
import br.com.jawc.domain.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProductDao implements IProductDao {
    @Override
    public Product save(Product product) {
            EntityManagerFactory entityManagerFactory =
                    Persistence.createEntityManagerFactory("ExampleJPA");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            entityManager.persist(product);
            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();


            return product;
    }
}
