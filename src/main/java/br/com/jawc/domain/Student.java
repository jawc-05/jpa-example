/**
 * @author jawc
 */
package br.com.jawc.domain;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @SequenceGenerator(name="student_sq", sequenceName = "sq_student", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "name",  nullable = false)
    private String name;

    @Column(name= "code", length = 10, nullable = false, unique = true)
    private String code;

    @OneToOne(mappedBy = "student")
    private Tuition tuition;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Tuition getTuition() {
        return tuition;
    }

    public void setTuition(Tuition tuition) {
        this.tuition = tuition;
    }
}
