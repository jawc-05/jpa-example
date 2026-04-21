/**
 * @author jawc
 */
package br.com.jawc.dao;

import br.com.jawc.dao.interfaces.ICourseDao;
import br.com.jawc.domain.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CourseDao implements ICourseDao {
    @Override
    public Course save(Course course) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExampleJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();


        return course;
    }
}
