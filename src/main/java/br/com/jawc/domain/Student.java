/**
 * @author jawc
 */
package br.com.jawc.domain;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.List;

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

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "tb_student_computer",
            joinColumns = {@JoinColumn(name = "id_student_fk")},
            inverseJoinColumns = {@JoinColumn(name = "id_computer_fk")})
    private List<Computer> computers;

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

    public List<Computer> getComputers() {
        return computers;
    }

    public void setComputers(List<Computer> computers) {
        this.computers = computers;
    }
}
