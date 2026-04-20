/**
 * @author jawc
 */
package br.com.jawc;

import br.com.jawc.dao.CourseDao;
import br.com.jawc.dao.ICourseDao;
import br.com.jawc.domain.Course;
import org.junit.Test;

public class CourseTest {
    private ICourseDao dao;
    public CourseTest(){
        dao = new CourseDao();
    }

    @Test
    public void save(){
        Course course = new Course();
        course.setCode("A1");
        course.setDescription("asdkjhKdskjhadkhs");
        course.setName("Java");
        dao.save(course);
    }
}
