/**
 * @author jawc
 */
package br.com.jawc;

import br.com.jawc.domain.Course;
import org.junit.Test;

public class CourseTest {

    @Test
    public void cadastrar(){
        Course course = new Course();
        course.setCode("A1");
        course.setDescription("asdkjhKdskjhadkhs");
        course.setName("Java");
        daoCouse.cadastrar(course);
    }
}
