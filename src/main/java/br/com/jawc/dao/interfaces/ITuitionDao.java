/**
 * @author jawc
 */
package br.com.jawc.dao.interfaces;

import br.com.jawc.domain.Course;
import br.com.jawc.domain.Tuition;

public interface  ITuitionDao {

    Tuition save(Tuition tuition);
    Tuition searchByCodeCourse(String codeCourse);

    Tuition searchByCourse(Course course);
}
