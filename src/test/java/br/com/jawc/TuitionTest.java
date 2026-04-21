/**
 * @author jawc
 */
package br.com.jawc;

import br.com.jawc.dao.CourseDao;
import br.com.jawc.dao.interfaces.ICourseDao;
import br.com.jawc.dao.interfaces.ITuitionDao;
import br.com.jawc.dao.TuitionDao;
import br.com.jawc.domain.Course;
import br.com.jawc.domain.Tuition;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.Instant;

public class TuitionTest {

    private ICourseDao courseDao;
    private ITuitionDao dao;


    public TuitionTest() {
        dao = new TuitionDao();
        courseDao = new CourseDao();
    }

    @Test
    public void saveTest(){
        Course course = createCourse("A2");

        Tuition tuition = new Tuition();
        tuition.setCode("A2");
        tuition.setPrice(new BigDecimal("500.00"));
        tuition.setDataTuition(Instant.now());
        tuition.setStatus("ATIVA");
        tuition.setCourse(course);
        tuition = dao.save(tuition);

        Assert.assertNotNull(tuition);
        Assert.assertNotNull(tuition.getId());
    }

    private Course createCourse(String code){
        Course course = new Course();
        course.setCode(code);
        course.setDescription("asdkjhKdskjhadkhs");
        course.setName("Java");
        return courseDao.save(course);
    }
}
