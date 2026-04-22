/**
 * @author jawc
 */
package br.com.jawc;

import br.com.jawc.dao.ComputerDao;
import br.com.jawc.dao.CourseDao;
import br.com.jawc.dao.StudentDao;
import br.com.jawc.dao.interfaces.IComputerDao;
import br.com.jawc.dao.interfaces.ICourseDao;
import br.com.jawc.dao.interfaces.IStudentDao;
import br.com.jawc.dao.interfaces.ITuitionDao;
import br.com.jawc.dao.TuitionDao;
import br.com.jawc.domain.Computer;
import br.com.jawc.domain.Course;
import br.com.jawc.domain.Student;
import br.com.jawc.domain.Tuition;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.Instant;

public class TuitionTest {

    private IStudentDao studentDao;
    private ICourseDao courseDao;
    private ITuitionDao tuitionDao;
    private IComputerDao computerDao;


    public TuitionTest() {
        tuitionDao = new TuitionDao();
        courseDao = new CourseDao();
        studentDao = new StudentDao();
        computerDao = new ComputerDao();
    }

    @Test
    public void saveTest(){
        Course course = createCourse("C1");
        Student student = createStudent("S1");


        Tuition tuition = new Tuition();
        tuition.setCode("C1");
        tuition.setPrice(new BigDecimal("500.00"));
        tuition.setDataTuition(Instant.now());
        tuition.setStatus("ATIVA");
        tuition.setCourse(course);
        tuition.setStudent(student);
        student.setTuition(tuition);
        tuition = tuitionDao.save(tuition);

        Assert.assertNotNull(tuition);
        Assert.assertNotNull(tuition.getId());

        Tuition tuitiondb = tuitionDao.searchByCodeCourse(tuition.getCode());
        Assert.assertNotNull(tuitiondb);
        Assert.assertEquals(tuitiondb.getId(), tuition.getId());

        Tuition tuitionObj = tuitionDao.searchByCourse(course);
        Assert.assertNotNull(tuitionObj);
        Assert.assertEquals(tuitionObj.getId(), tuition.getId());
    }

    private Course createCourse(String code){
        Course course = new Course();
        course.setCode(code);
        course.setDescription("asdkjhKdskjhadkhs");
        course.setName("Java");
        return courseDao.save(course);
    }

    private Student createStudent(String code){
        Computer computer = createComputer("Comp1");
        Computer computer2 = createComputer("Comp2");

        Student student = new Student();

        student.setCode(code);
        student.setName("Jawc");

        student.addComputer(computer);
        student.addComputer(computer2);
        return studentDao.save(student) ;
    }

    private Computer createComputer(String code){
        Computer computer = new Computer();
        computer.setCode(code);
        computer.setDescription("MACBOOK AIR M4");
        return computer;
    }
}
